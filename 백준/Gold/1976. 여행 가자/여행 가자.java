import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N];
		rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st1.nextToken());
				
				if (num == 1) {
					union(i, j);
				}
			}
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int p = find(Integer.parseInt(st2.nextToken()) - 1);
		
		for (int i = 1; i < M; i++) {
			int num = Integer.parseInt(st2.nextToken()) - 1;
			
			if (find(num) != p) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	public static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if (p1 == p2) return;
		
		if (rank[p1] > rank[p2]) {
			parent[p2] = p1;
		} else if (rank[p1] < rank[p2]) {
			parent[p1] = p2;
		} else {
			parent[p2] = p1;
			rank[p1]++;
		}
	}
	
	public static int find(int n) {
		if (parent[n] != n) {
			return parent[n] = find(parent[n]);
		}
		return parent[n];
	}
}