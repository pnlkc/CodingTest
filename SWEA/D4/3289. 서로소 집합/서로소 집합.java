import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pos {
	long x, y;

	public Pos(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

class Node implements Comparable<Node> {
	int s, e;
	long d;

	public Node(int s, int e, long d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Node o) {
		if (d < o.d) {
			return -1;
		} else if (d > o.d) {
			return 1;
		} else {
			return 0;
		}
	}
}

public class Solution {
	static int[] parent, rank;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st1.nextToken());
			int m = Integer.parseInt(st1.nextToken());

			parent = new int[n + 1];
			rank = new int[n + 1];
			
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st2.nextToken());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				if (c == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			sb.append("\n");
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