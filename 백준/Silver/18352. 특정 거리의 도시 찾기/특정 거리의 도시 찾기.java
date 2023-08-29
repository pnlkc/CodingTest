import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int n, d;

	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		int X = Integer.parseInt(st1.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());
			
			graph.get(A).add(B);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.d - n2.d);
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] isVisit = new boolean[N + 1];
		pq.offer(new Node(X, 0));
		dist[X] = 0;
		
		while (!pq.isEmpty()) {
			Node c = pq.poll();
			
			if (isVisit[c.n]) continue;
			isVisit[c.n] = true;
			
			for (int n : graph.get(c.n)) {
				if (!isVisit[n] && dist[n] > dist[c.n] + 1) {
					dist[n] = dist[c.n] + 1;
					pq.offer(new Node(n, dist[n]));
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				sb.append(i).append("\n");
			}
		}
		
		if (sb.toString().length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}
}