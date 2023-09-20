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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Pos[] island = new Pos[N];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(br.readLine());
			
			parent = new int[N];
			rank = new int[N];
			
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < N; i++) {
				island[i] = new Pos(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					
					pq.add(new Node(i, j, calcDist(island[i], island[j])));
				}
			}
			
			int cnt = 0;
			long sum = 0;
			
			while (!pq.isEmpty()) {
				Node c = pq.poll();
				if (union(c.s, c.e)) {
					sum += c.d;
					if (++cnt == N - 1) {
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + Math.round(E * sum));
		}
	}
	
	public static long calcDist(Pos p1, Pos p2) {
		long xDiff = p1.x - p2.x;
		long yDiff = p1.y - p2.y;
		return xDiff * xDiff + yDiff * yDiff;
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