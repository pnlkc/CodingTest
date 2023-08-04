import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine());

		p: for (int tc = 0; tc < tcNum; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st1.nextToken());
			int m = Integer.parseInt(st1.nextToken());
			int w = Integer.parseInt(st1.nextToken());
			Map<Integer, Integer>[] graph = new HashMap[n + 1];

			for (int i = 0; i < m + w; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st2.nextToken());
				int e = Integer.parseInt(st2.nextToken());
				int t = Integer.parseInt(st2.nextToken());

				if (i < m) {	
					if (graph[s] == null) graph[s] = new HashMap<>();

					if (graph[s].get(e) == null) graph[s].put(e, t);
					else graph[s].put(e, Math.min(graph[s].get(e), t));
					
					if (graph[e] == null) graph[e] = new HashMap<>();

					if (graph[e].get(s) == null) graph[e].put(s, t);
					else graph[e].put(s, Math.min(graph[e].get(s), t));
				} else {
					if (graph[s] == null) graph[s] = new HashMap<>();

					if (graph[s].get(e) == null) graph[s].put(e, t * -1);
					else graph[s].put(e, Math.min(graph[s].get(e), t * -1));
				}
			}

			if (bellmanford(n, graph)) {
				System.out.println("YES");
				continue p;
			}
			
			System.out.println("NO");
		}
	}

	public static boolean bellmanford(int n, Map<Integer, Integer>[] graph) {
		int[] dist = new int[n + 1];
		dist[1] = 0;

		for (int i = 0; i < n - 1; i++) {
            boolean isChange = false;
            
			for (int j = 1; j <= n; j++) {
				if (graph[j] != null) {
					for (int e : graph[j].keySet()) {
						if (dist[j] + graph[j].get(e) < dist[e]) {
							dist[e] = dist[j] + graph[j].get(e);
                            isChange = true;
						}
					}
				}
			}
            
            if (!isChange) break;
		}

		for (int i = 1; i <= n; i++) {
			if (graph[i] != null) {
				for (int e : graph[i].keySet()) {
					if (dist[e] > dist[i] + graph[i].get(e)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}