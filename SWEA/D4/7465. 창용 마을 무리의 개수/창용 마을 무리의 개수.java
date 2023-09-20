import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());

			parent = new int[N + 1];
			rank = new int[N + 1];
			
			for (int i = 0; i <= N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				union(a, b);
			}
			
			List<Integer> pList = new ArrayList<>();
			
			for (int i = 1; i <= N; i++) {
				if (!pList.contains(find(i))) {
					pList.add(find(i));
				}
			}
			
			sb.append("#" + tc + " " + pList.size()).append("\n");
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