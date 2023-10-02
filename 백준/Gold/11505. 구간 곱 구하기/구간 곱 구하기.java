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
		int K = Integer.parseInt(st1.nextToken());
		long[] arr = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		ST st = new ST(N);
		st.init(arr, 1, 1, N);
		
		for (int i = 0; i < M + K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			
			if (a == 1) {
				st.update(arr, 1, 1, N, b, c);
			} else {
				sb.append(st.calc(1, 1, N, b, c) + "\n");
			}
		}
		
		System.out.print(sb);
	}
}

class ST {
	final int NUM = 1_000_000_007;
	long[] tree;
	
	public ST(int n) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int cnt = (int) Math.pow(2, h + 1);
		tree = new long[cnt];
	}
	
	public void init(long[] arr, int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[e];
		} else {
			init(arr, node * 2, s, (s + e) / 2);
			init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
			tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % NUM;
		}
	}
	
	public long calc(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return 1L;
		}
		
		if (l <= s && r >= e) {
			return tree[node];
		}
		
		long lCalc = calc(node * 2, s, (s + e) / 2, l, r);
		long rCalc = calc(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		
		return (lCalc * rCalc) % NUM;
	}
	
	public void update(long[] arr, int node, int s, int e, int idx, int num) {
		if (s > idx || e < idx) {
			return;
		}
		
		if (s == idx && e == idx) {
			tree[node] = num;
			arr[idx] = num;
			return;
		}
		
		update(arr, node * 2, s, (s + e) / 2, idx, num);
		update(arr, node * 2 + 1, (s + e) / 2 + 1, e, idx, num);
		tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % NUM;
	}
}