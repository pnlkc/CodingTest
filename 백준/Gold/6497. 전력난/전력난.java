import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class V {
	int a, b, d;

	public V(int a, int b, int d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}
}

public class Main {
	static int[] parent, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st1.nextToken());
			int n = Integer.parseInt(st1.nextToken());
			int cnt = 0;
			int sum = 0;
			parent = new int[m];
			rank = new int[m];
			
			for (int i = 0; i < m; i++) {
				parent[i] = i;
			}
			
			if (m == 0 && n == 0) break;
			
			PriorityQueue<V> pq = new PriorityQueue<>((V v1, V v2) -> v1.d - v2.d);
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				int d = Integer.parseInt(st2.nextToken());
				
				sum += d;
				pq.offer(new V(a, b, d));
			}
			
			while (!pq.isEmpty()) {
				V c = pq.poll();
				
				if (union(c.a, c.b)) {
					sum -= c.d;
					if (++cnt == m - 1) {
						break;
					}
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if (p1 == p2) return false;
		
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