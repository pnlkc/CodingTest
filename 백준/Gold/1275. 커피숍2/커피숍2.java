import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ST segmentTree = new ST(N);
		segmentTree.init(arr, 1, 1, N);
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(segmentTree.preSum(arr, 1, 1, N, Math.min(x, y), Math.max(x, y)) + "\n");
			segmentTree.update(arr, 1, 1, N, a, b);
		}
		
		System.out.print(sb);
	}
}

class ST {
	long[] tree;
	
	public ST(int N) {
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int cnt = (int) Math.pow(2, h + 1);
		tree = new long[cnt];
	}
	
	public void init(long[] arr, int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[e];
			return;
		}
		
		init(arr, node * 2, s, (s + e) / 2);
		init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	public long preSum(long[] arr, int node, int s, int e, int l, int r) {
		if (r < s || l > e) {
			return 0L;
		}
		
		if (l <= s && r >= e) {
			return tree[node];
		}
		
		long lSum = preSum(arr, node * 2, s, (s + e) / 2, l, r);
		long rSum = preSum(arr, node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		return lSum + rSum;
	}
	
	public void update(long[] arr, int node, int s, int e, int idx, int num) {
		if (idx < s || e < idx) {
			return;
		}
		
		if (s == idx && e == idx) {
			tree[node] = num;
			arr[idx] = num;
			return;
		}
		
		update(arr, node * 2, s, (s + e) / 2, idx, num);
		update(arr, node * 2 + 1, (s + e) / 2 + 1, e, idx, num);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}