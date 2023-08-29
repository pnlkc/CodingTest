import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Vertex {
	int a, b;

	public Vertex(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class Main {
	static int[] parent, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			parent = new int[N];
			rank = new int[N];
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken()) - 1;
				int b = Integer.parseInt(st2.nextToken()) - 1;
				
				if (union(a, b)) {
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
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