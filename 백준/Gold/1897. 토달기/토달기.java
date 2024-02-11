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

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		String str = st.nextToken();
		String result = "";
		Map<Integer, List<String>> map = new HashMap<>();
		Map<String, Boolean> isVisit = new HashMap<>();
		
		for (int i = 0; i <= 81; i++) {
			map.put(i, new ArrayList<>());
		}
		
		for (int i = 0; i < d; i++) {
			String input = br.readLine();
			map.get(input.length()).add(input);
			isVisit.put(input, false);
		}
		
		Queue<String> q = new LinkedList<>();
		q.add(str);
		isVisit.put(str, true);
		
		while (!q.isEmpty()) {
			String c = q.poll();
			
			if (c.length() > result.length()) {
				result = c;
			}
			
			for (String next : map.get(c.length() + 1)) {
				int idx = 0;
				
				for (char i : next.toCharArray()) {
					if (i == c.charAt(idx)) {
						if (++idx == c.length()) {
							break;
						}
					}
				}
				
				if (idx == c.length() && !isVisit.get(next)) {
					q.add(next);
					isVisit.put(next, true);
				}
			}
		}
		
		System.out.println(result);
	}
}