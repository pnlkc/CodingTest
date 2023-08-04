import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
	int e, d;

	public Node(int e, int d) {
		this.e = e;
		this.d = d;
	}
}

public class Main {
	static int n;
	static List<List<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		p: for (int tc = 0; tc < tcNum; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st1.nextToken());
			int m = Integer.parseInt(st1.nextToken());
			int w = Integer.parseInt(st1.nextToken());
			graph = new ArrayList<>();
			for (int i = 0; i < n + 1; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < m + w; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st2.nextToken());
				int e = Integer.parseInt(st2.nextToken());
				int t = Integer.parseInt(st2.nextToken());

				if (i < m) {
					graph.get(s).add(new Node(e, t));
					graph.get(e).add(new Node(s, t));
				} else {
					graph.get(s).add(new Node(e, -t));
				}
			}

			for (int i = 1; i <= n; i++) {
				if (bellmanford(i)) {
					sb.append("YES").append("\n");
					continue p;
				}
			}

			sb.append("NO").append("\n");
		}

		System.out.println(sb);
	}

	public static boolean bellmanford(int s) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;

		for (int i = 0; i < n - 1; i++) {
			boolean isChange = false;
			
			for (int j = 1; j <= n; j++) {
				for (Node node : graph.get(j)) {
					if (dist[j] != Integer.MAX_VALUE && dist[node.e] > dist[j] + node.d) {
						dist[node.e] = dist[j] + node.d;
						isChange = true;
					}
				}
			}
			
			if (!isChange) break;
		}

		for (int i = 1; i <= n; i++) {
			for (Node node : graph.get(i)) {
				if (dist[i] != Integer.MAX_VALUE && dist[node.e] > dist[i] + node.d) {
					return true;
				}
			}
		}

		return false;
	}
}