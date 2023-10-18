import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		BigInteger[] arr = new BigInteger[N + 1];
		
		for (int i = 1; i <= N; i++) {
			BigInteger num = BigInteger.valueOf(Long.parseLong(br.readLine()));
			arr[i] = num;
		}
		
		ST sTree = new ST(N);
		sTree.init(arr, 1, 1, N);
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				long d = Long.parseLong(st.nextToken());
				
				sTree.change(arr, 1, 1, N, b, c, BigInteger.valueOf(d));
			} else {
				sb.append(sTree.preSum(arr, 1, 1, N, b, c) + "\n");
			}
		}
		
		System.out.print(sb);
	}
}

class ST {
	BigInteger[] tree;
	BigInteger[] lazy;
	
	public ST(int N) {
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int cnt = (int) Math.pow(2, h + 1);
		tree = new BigInteger[cnt];
		lazy = new BigInteger[cnt];
		
		Arrays.fill(tree, BigInteger.ZERO);
		Arrays.fill(lazy, BigInteger.ZERO);
	}
	
	public void init(BigInteger[] arr, int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[e];
			return;
		}
		
		init(arr, node * 2 , s, (s + e) / 2);
		init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
		
		tree[node] = tree[node * 2].add(tree[node * 2 + 1]);
	}
	
	public void updateLazy(int node, int s, int e) {
		if (lazy[node] != BigInteger.ZERO) {
			tree[node] = tree[node].add(lazy[node].multiply(BigInteger.valueOf(e - s + 1)));
			
			if (s != e) {
				lazy[node * 2] = lazy[node * 2].add(lazy[node]);
				lazy[node * 2 + 1] = lazy[node * 2 + 1].add(lazy[node]);
			}
			
			lazy[node] = BigInteger.ZERO;
		}
	}
	
	public BigInteger preSum(BigInteger[] arr, int node, int s, int e, int l, int r) {
		updateLazy(node, s, e);
		
		if (r < s || l > e) {
			return BigInteger.ZERO;
		}
		
		if (l <= s && e <= r) {
			return tree[node];
		}
		
		BigInteger lSum = preSum(arr, node * 2, s, (s + e) / 2, l, r);
		BigInteger rSum = preSum(arr, node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		
		return lSum.add(rSum);
	}
	
	public void change(BigInteger[] arr, int node, int s, int e, int l, int r, BigInteger diff) {
		updateLazy(node, s, e);
		
		if (r < s || e < l) {
			return;
		}
		
		if (l <= s && e <= r) {
			tree[node] = tree[node].add(diff.multiply(BigInteger.valueOf(e - s + 1)));
			
			if (s != e) {
				lazy[node * 2] = lazy[node * 2].add(diff);
				lazy[node * 2 + 1] = lazy[node * 2 + 1].add(diff);
			}
			
			return;
		}
		
		change(arr, node * 2, s, (s + e) / 2, l, r, diff);
		change(arr, node * 2 + 1, (s + e) / 2 + 1, e, l, r, diff);
		
		tree[node] = tree[node * 2].add(tree[node * 2 + 1]);
	}
}