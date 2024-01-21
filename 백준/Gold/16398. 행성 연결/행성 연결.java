import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> arr1[2] - arr2[2]);
		int cnt = 0;
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i == j) continue;
				
				pq.add(new int[]{ i, j, arr[i][j] });
			}
		}
		
		UF uf = new UF(N);
		
		while (!pq.isEmpty()) {
			int[] c = pq.poll();
			boolean r = uf.union(c[0], c[1]);
			
			if (r) {
				result += c[2];
				
				if (++cnt == N - 1) 
					break;
			}
		}
		
		System.out.println(result);
	}
}

class UF {
	int n;
	int[] parent, rank;

	public UF(int n) {
		this.n = n;
		parent = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	int find(int node) {
		if (parent[node] != node) {
			return parent[node] = find(parent[node]);
		}

		return parent[node];
	}

	boolean union(int node1, int node2) {
		int root1 = find(node1);
		int root2 = find(node2);

		if (root1 == root2)
			return false;

		if (rank[root1] > rank[root2]) {
			parent[root2] = root1;
		} else if (rank[root1] < rank[root2]) {
			parent[root1] = root2;
		} else {
			parent[root2] = root1;
			rank[root1]++;
		}
		
		return true;
	}
}