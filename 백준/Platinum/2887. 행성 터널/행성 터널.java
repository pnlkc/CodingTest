import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int n, x, y, z;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public Node(int n, int x, int y, int z) {
		this.n = n;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Dist {
	int a, b, d;

	public Dist(int a, int b, int d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}
}

public class Main {
	static int cnt = 0;
	static int[] parent, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N];
		PriorityQueue<Dist> pq = new PriorityQueue<>((Dist o1, Dist o2) -> o1.d - o2.d);
		parent = new int[N];
		rank = new int[N];
		long sum = 0;
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			arr[i] = new Node(i, x, y, z);
		}

		Node[] xSort = arr.clone();
		Arrays.sort(xSort, Comparator.comparing(Node::getX));
		Node[] ySort = arr.clone();
		Arrays.sort(ySort, Comparator.comparing(Node::getY));
		Node[] zSort = arr.clone();
		Arrays.sort(zSort, Comparator.comparing(Node::getZ));
		
		for (int i = 0; i < N; i++) {
			if (i - 1 >= 0) {
				pq.add(new Dist(xSort[i].n, xSort[i - 1].n, xSort[i].x - xSort[i - 1].x));
				pq.add(new Dist(ySort[i].n, ySort[i - 1].n, ySort[i].y - ySort[i - 1].y));
				pq.add(new Dist(zSort[i].n, zSort[i - 1].n, zSort[i].z - zSort[i - 1].z));
			}
			
			if (i + 1 < N) {
				pq.add(new Dist(xSort[i].n, xSort[i + 1].n, xSort[i + 1].x - xSort[i].x));
				pq.add(new Dist(ySort[i].n, ySort[i + 1].n, ySort[i + 1].y - ySort[i].y));
				pq.add(new Dist(zSort[i].n, zSort[i + 1].n, zSort[i + 1].z - zSort[i].z));
			}
		}
		
		while (!pq.isEmpty()) {
			Dist c = pq.poll();
			
			if (union(c.a, c.b)) {
				sum += c.d;
				if (cnt == N - 1) break;
			}
		}
		
		System.out.println(sum);
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
		
		cnt++;
		
		return true;
	}
	
	public static int find(int n) {
		if (parent[n] != n ) {
			return find(parent[n]);
		}
		return parent[n];
	}
}