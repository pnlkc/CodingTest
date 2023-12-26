import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (; tc > 0; tc--) {
			List<List<Data>> graph = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (; d > 0; d--) {
				st  = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				graph.get(b).add(new Data(b, a, s));
			}
			
			PriorityQueue<Data> pq = new PriorityQueue<>((Data d1, Data d2) -> d1.t - d2.t);
			int[] dist = new int[n + 1];
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			pq.add(new Data(c, 0, 0));
			dist[c] = 0;
			
			while (!pq.isEmpty()) {
				Data current = pq.poll();
				
				for (Data next : graph.get(current.s)) {
					if (dist[next.e] > dist[current.s] + next.t) {
						dist[next.e] = dist[current.s] + next.t;
						pq.offer(new Data(next.e, 0, dist[next.s]));
					}
				}
			}
			
			int cnt = 0;
			int max = 0;
			
			for (int i = 1; i <= n; i++ ) {
				if (dist[i] != Integer.MAX_VALUE) {
					cnt++;
					max = Math.max(max, dist[i]);
				}
			}
			
			sb.append(cnt + " " + max + "\n");
		}
		
		System.out.print(sb);
	}
}

class Data {
	int s, e, t;

	public Data(int s, int e, int t) {
		this.s = s;
		this.e = e;
		this.t = t;
	}
}