import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int e, d;

	public Node(int e, int d) {
		super();
		this.e = e;
		this.d = d;
	}
}

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		List<List<Node>> graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()) - 1)
					.add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st2.nextToken()) - 1;
		int b = Integer.parseInt(st2.nextToken()) - 1;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.d - o2.d;
			}
		});
		int[] dist = new int[N];
		pq.add(new Node(a, 0));
		Arrays.fill(dist, -1);
		dist[a] = 0;
		
		while (!pq.isEmpty()) {
			Node cn = pq.poll();
			
			if (dist[cn.e] != -1 && cn.d > dist[cn.e]) continue;
			
			for (Node nn : graph.get(cn.e)) {
				if (dist[nn.e] == -1 || dist[nn.e] > dist[cn.e] + nn.d) {
					dist[nn.e] = dist[cn.e] + nn.d;
					pq.add(new Node(nn.e, dist[nn.e]));
				}
			}
		}

		System.out.println(dist[b]);
	}
}