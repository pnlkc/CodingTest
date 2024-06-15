import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		List<List<Node>> graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			graph.get(p).add(new Node(q, r));
			graph.get(q).add(new Node(p, r));
		}
		
		for (int t = 0; t < Q; t++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
			boolean[] isVisit = new boolean[N + 1];
			int cnt = 0;
			
			q.offer(v);
			isVisit[v] = true;
			
			while(!q.isEmpty()) {
				int c = q.poll();
				
				for (Node n : graph.get(c)) {
					if (isVisit[n.n]) continue;
					if (n.d < k) continue;
					
					q.add(n.n);
					isVisit[n.n] = true;
					cnt++;
				}
			}
		
			sb.append(cnt).append("\n");
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