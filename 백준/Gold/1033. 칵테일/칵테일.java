import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
			result[i] = 1;
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			long q = Long.parseLong(st.nextToken());
			
			long pqGcd = gcd(p, q);
			p /= pqGcd;
			q /= pqGcd;
			
			long l = result[b] * p;
			long r = result[a] * q;
			
			bfs(a, l, N, list, result);
			bfs(b, r, N, list, result);
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		long gcd = 0;
		
		for (int i = 0; i < N; i++) {
			gcd = gcd(gcd, result[i]);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(result[i] / gcd);
			if (i != N - 1) System.out.print(" ");
		}
	}

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
	
	public static void bfs(int node, long num, int N, List<List<Integer>> list, int[] result) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisit = new boolean[N];
		
		q.add(node);
		isVisit[node] = true;
		
		while (!q.isEmpty()) {
			int c = q.poll();
			
			result[c] *= num;
			
			for (int next : list.get(c)) {
				if (isVisit[next]) continue;
				isVisit[next] = true;
				q.offer(next);
			}
		}
	}
}

class Data {
	long a, b;

	public Data(long a, long b) {
		this.a = a;
		this.b = b;
	}	
}