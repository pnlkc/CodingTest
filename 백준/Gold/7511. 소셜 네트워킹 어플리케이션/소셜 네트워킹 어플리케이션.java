import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= tc; t++) {
			sb.append("Scenario " + t + ":" + "\n");
			
			int n = Integer.parseInt(br.readLine());
			UnionFind uf = new UnionFind(n);
			int m = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				uf.union(a, b);
			}
			
			int o = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < o; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				boolean result = uf.isConnected(a, b);
				
				if (result) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
			
			if (t != tc) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}

class UnionFind {
	int[] parent, rank;
	
	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	public int find(int node) {
		if (parent[node] != node) {
			return parent[node] = find(parent[node]);
		}
		
		return parent[node];
	}
	
	public void union(int node1, int node2) {
		int root1 = find(node1);
		int root2 = find(node2);
		
		if (root1 == root2) return;
		
		if (rank[root1] > rank[root2]) {
			parent[root2] = root1;
		} else if (rank[root1] < rank[root2]) {
			parent[root1] = root2;
		} else {
			rank[root1]++;
			parent[root2] = root1;
		}
	}
	
	public boolean isConnected(int node1, int node2) {
		return find(node1) == find(node2);
	}
}