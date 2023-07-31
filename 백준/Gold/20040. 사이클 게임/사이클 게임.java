import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		int[] parent = new int[n];
		int[] rank = new int[n];
		int[] check = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st2.nextToken());
			int n2 = Integer.parseInt(st2.nextToken());
			check[n1]++;
			check[n2]++;
			
			if (!union(parent, rank, n1, n2)) {
				System.out.println(i + 1);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	public static boolean union(int[] parent, int[] rank, int n1, int n2) {
		int p1 = find(parent, n1);
		int p2 = find(parent, n2);
		
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
	
	public static int find(int[] parent, int n) {
		if (parent[n] != n) {
			return find(parent, parent[n]);
		}
		return parent[n];
	}
}