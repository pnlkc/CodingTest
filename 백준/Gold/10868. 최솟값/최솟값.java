import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		ST st = new ST(N);
		st.init(arr, 1, 1, N);
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			sb.append(st.find(1, 1, N, a, b)).append("\n");
		}
		
		System.out.print(sb);
	}
}

class ST {
	int[] tree;
	
	ST(int N) {
		int log = (int) (Math.log(N) / Math.log(2)) + 1;
		int cnt = (int) Math.pow(2, log + 1) + 1;
		tree = new int[cnt];
	}
	
	void init(int[] arr, int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[s];
			return;
		}
		
		init(arr, node * 2, s, (s + e) / 2);
		init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
		
		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}
	
	int find(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return Integer.MAX_VALUE;
		}
		
		if (l <= s && r >= e) {
			return tree[node];
		}
		
		int lMin = find(node * 2, s, (s + e) / 2, l, r);
		int rMin = find(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		
		return Math.min(lMin, rMin);
	}
}