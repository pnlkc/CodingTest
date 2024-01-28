import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, List<String>> graph = new HashMap<>();
		Map<String, Integer> cnt = new HashMap<>();
		Map<String, Double> result = new HashMap<>();
		
		String str = br.readLine();
		graph.put(str, new ArrayList<>());
		cnt.put(str, 0);
		result.put(str, 1.0);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String p1 = st.nextToken();
			String p2 = st.nextToken();
			
			if (cnt.get(name) == null) {
				cnt.put(name, 0);
			}
			
			if (graph.get(p1) == null) {
				graph.put(p1, new ArrayList<>());
			}
			
			graph.get(p1).add(name);
			
			if (graph.get(p2) == null) {
				graph.put(p2, new ArrayList<>());
			}
			
			graph.get(p2).add(name);
			
			if (cnt.get(p1) == null) {
				cnt.put(p1, 0);
			}
			
			if (cnt.get(p2) == null) {
				cnt.put(p2, 0);
			}
			
			cnt.put(name, 2);
		}
		
		Queue<String> q = new LinkedList<>();
		
		for (String key : cnt.keySet()) {
			if (cnt.get(key) == 0) {
				q.add(key);
				
				if (!key.equals(str)) {
					result.put(key, 0.0);
				}
			}
		}
		
		while (!q.isEmpty()) {
			String c = q.poll();
			
			if (graph.get(c) != null) {
				for (String next : graph.get(c)) {
					cnt.put(next, cnt.get(next) - 1);
					
					if (result.get(next) == null) {
						result.put(next, result.get(c) / 2);
					} else {
						result.put(next, result.get(next) + result.get(c) / 2);
					}
					
					
					if (cnt.get(next) == 0) {
						q.add(next);
					}
				}
			}
		}
		
		double max = 0.0;
		String r = "";
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			
			if (result.get(input) != null && max < result.get(input)) {
				r = input;
				max = result.get(input);
			}
		}
		
		System.out.println(r);
	}
}