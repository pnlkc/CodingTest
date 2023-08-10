import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] graph;
	static int[] input;
	static int[] dist;
	static boolean[] isVisit;
	static int cnt;
	static int r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			r = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph = new int[n];
			input = new int[n];
			dist = new int[n];
			Arrays.fill(dist, 1);

			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				graph[i] = num;
				input[num]++;
			}

			isVisit = new boolean[n];

			for (int i = 0; i < n; i++) {
				if (!isVisit[i]) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					dfs(i, list);
				}
			}

			System.out.println(n - r);
		}
	}

	public static void dfs(int n, List<Integer> list) {
		cnt--;
		isVisit[n] = true;

		if (isVisit[graph[n]]) {
			if (list.contains(graph[n]))
				r += dist[n] - dist[graph[n]] + 1;
		} else {
			dist[graph[n]] += dist[n];
			list.add(graph[n]);
			dfs(graph[n], list);
			list.remove(list.size() - 1);
		}
	}
}