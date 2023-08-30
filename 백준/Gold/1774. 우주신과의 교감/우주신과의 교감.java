import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class P {
	int x, y;

	public P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class V implements Comparable<V> {
	int a, b; 
	double d;

	public V(int a, int b, double d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}

	@Override
	public int compareTo(V o) {
		return Double.compare(d, o.d);
	}
}

public class Main {
	static int[] parent, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		P[] arr = new P[N + 1];
		PriorityQueue<V> pq = new PriorityQueue<>();
		parent = new int[N + 1];
		rank = new int[N + 1];
		int cnt = 0;
		double sum = 0;

		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= N; i ++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			
			arr[i] = new P(x, y);
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st3.nextToken());
			int y = Integer.parseInt(st3.nextToken()); 
			
			if (union(x, y)) {
				cnt++;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				pq.offer(new V(i, j, calcDist(arr[i], arr[j])));
			}
		}
		
		while (!pq.isEmpty()) {
			V c = pq.poll();
			
			if (union(c.a, c.b)) {
				sum += c.d;
				if (++cnt == N - 1) {
					break;
				}
			}
		}
		
		System.out.printf("%.2f\n", sum);
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
	
	public static double calcDist(P a, P b) {
		long xD = a.x - b.x;
		long yD = a.y - b.y;
		return Math.sqrt(xD * xD + yD * yD);
	}
}