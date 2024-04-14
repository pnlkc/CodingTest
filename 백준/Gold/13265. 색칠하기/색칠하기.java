import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		p: for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			List<List<Integer>> graph = new ArrayList<>();
			
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph.get(x).add(y);
				graph.get(y).add(x);
			}
			
			for (int i = 1; i <= n; i++) {
				Queue<Integer> q = new LinkedList<Integer>();
				int[] isVisit = new int[n + 1];
				
				q.add(i);
				if (isVisit[i] != 0) continue;
				isVisit[i] = 1;
				
				while (!q.isEmpty()) {
					int c = q.poll();
					
					for (int next : graph.get(c)) {
						if (isVisit[next] != 0) {
							if (isVisit[c] == isVisit[next]) {
								sb.append("impossible\n");
								continue p;
							}
						} else {
							if (isVisit[c] == 1) {
								isVisit[next] = 2;
							} else if (isVisit[c] == 2) {
								isVisit[next] = 1;
							}
							
							q.add(next);
						}
					}
				}
			}
			
			sb.append("possible\n");
		}
		
		System.out.print(sb);
	}
}