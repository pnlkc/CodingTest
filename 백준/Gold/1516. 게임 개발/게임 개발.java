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
		int N = Integer.parseInt(br.readLine());
		List<List<Node>> graph = new ArrayList<>();
		int[] times = new int[N + 1];
		int[] cnt = new int[N + 1];
		int[] result = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			times[i] = time;
			
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num == -1) {
					break;
				}
				
				graph.get(num).add(new Node(i, 0));
				cnt[i]++;
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) {
				result[i] = times[i];
				q.add(new Node(i, times[i]));
			}
		}
		
		while (!q.isEmpty()) {
			Node c = q.poll();
			
			for (Node n : graph.get(c.n)) {
				cnt[n.n]--;
				
				if (cnt[n.n] == 0) {
					result[n.n] = Math.max(result[n.n], c.d + times[n.n]);
					q.offer(new Node(n.n, result[n.n]));
				} else if (cnt[n.n] > 0) {
					result[n.n] = Math.max(result[n.n], c.d + times[n.n]);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(result[i] + "\n");
		}
		
		System.out.print(sb);
	}
}

class Node {
	int n, d;

	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}