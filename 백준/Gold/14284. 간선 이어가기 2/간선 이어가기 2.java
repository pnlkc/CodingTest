import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<List<Node>> graph = new ArrayList<List<Node>>(); 
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int s =  Integer.parseInt(st.nextToken());
		int t =  Integer.parseInt(st.nextToken());
		int[] dist = new int[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.d - n2.d);
		
		pq.add(new Node(s, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		
		while (!pq.isEmpty()) {
			Node c = pq.poll();
			
			for (Node next : graph.get(c.n)) {
				if (c.d + next.d < dist[next.n]) {
					dist[next.n] = c.d + next.d;
					pq.add(new Node(next.n, dist[next.n]));
				}
			}
		}
		
		System.out.println(dist[t]);
	}
}

class Node {
	int n, d;

	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}