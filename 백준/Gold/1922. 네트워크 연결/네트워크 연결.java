import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int a, b, c;

	public Node(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class Main {
	static int[] parent, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		rank = new int[N + 1];
		int sum = 0;
		int cnt = 0;
		
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.c - n2.c);
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a, b, c));
		}
		
		while (!pq.isEmpty()) {
			Node cn = pq.poll();
			
			if (union(cn.a, cn.b)) {
				sum += cn.c;
				
				if (++cnt == N - 1) {
					break;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	public static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 == p2) return false;
		
		if (rank[p1] > rank[p2]) {
			parent[p2] = p1;
		} else if (rank[p1] < rank[p2]) {
			parent[p1] = p2;
		} else {
			parent[p2] = p1;
			rank[p1]++;
		}
		
		return true;
	}
	
	public static int find(int n) {
		if (parent[n] != n) {
			return parent[n] = find(parent[n]);
		}
		
		return parent[n];
	}
}