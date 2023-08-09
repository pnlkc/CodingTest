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

class Node {
	int n, t;

	public Node(int n, int t) {
		this.n = n;
		this.t = t;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());
			int[] dL = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				dL[i] = Integer.parseInt(st2.nextToken());
			}
			
			Map<Integer, List<Integer>> graph = new HashMap<>();
			int[] cnt = new int[N];
			for (int i = 0; i < K; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st3.nextToken()) - 1;
				int Y = Integer.parseInt(st3.nextToken()) - 1;
				if (graph.get(X) == null) graph.put(X, new ArrayList<>());
				graph.get(X).add(Y);
				cnt[Y]++;
			}
			int W = Integer.parseInt(br.readLine()) - 1;
			
			Queue<Node> queue = new LinkedList<>();
			int[] dist = new int[N];
			
			for (int i = 0; i < N; i++) {
				if (cnt[i] == 0) {
					queue.add(new Node(i, dL[i]));
					dist[i] = dL[i];
				}
			}
			
			while (!queue.isEmpty()) {
				Node c = queue.poll();
				if (c.n == W) break;
				
				if (graph.get(c.n) != null) {
					for (int nn : graph.get(c.n)) {
						cnt[nn]--;
						if (cnt[nn] >= 0) {
							dist[nn] = Math.max(dist[nn], c.t + dL[nn]);
							if (cnt[nn] == 0) {
								queue.add(new Node(nn, dist[nn]));
							}
						}
					}
				}
			}
			
			System.out.println(dist[W]);
		}
	}
}