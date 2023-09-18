import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			List<List<Integer>> graph = new ArrayList<>();
			cnt = 0;
			
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				
				graph.get(x).add(y);
				graph.get(y).add(x);
			}
			
			for (int i = 1; i <= N; i++) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				dfs(graph, i, list);
			}
			
			
			System.out.println("#" + tc + " " + (cnt / 6));
		}
	}
	
	public static void dfs(List<List<Integer>> graph, int n, List<Integer> list) {
		if (list.size() == 3) {
			if (graph.get(list.get(2)).contains(list.get(0))) {
				cnt++;
			}
			
			return;
		}
		
		for (int nn : graph.get(n)) {
			if (!list.contains(nn)) {
				list.add(nn);
				dfs(graph, nn, list);
				list.remove(list.size() - 1);
			}
		}
	}
}