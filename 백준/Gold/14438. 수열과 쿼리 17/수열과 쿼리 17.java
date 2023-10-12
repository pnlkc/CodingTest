import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		ST segmentTree = new ST(N);
		segmentTree.init(arr, 1, 1, N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				segmentTree.update(arr, 1, 1, N, b, c);
			} else {
				sb.append(segmentTree.min(arr, 1, 1, N, b, c) + "\n");
			}
		}
		
		System.out.print(sb);
	}
}

class ST {
	int[] tree;
	
	public ST(int N) {
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int cnt = (int) Math.pow(2, h + 1);
		tree = new int[cnt];
	}
	
	public void init(int[] arr, int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[e];
			return;
		}
		
		init(arr, node * 2, s, (s + e) / 2);
		init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}
	
	public int min(int[] arr, int node, int s, int e, int l, int r) {
		if (r < s || l > e) {
			return Integer.MAX_VALUE;
		}
		
		if (l <= s && r >= e) {
			return tree[node];
		}
		
		int lMin = min(arr, node * 2, s, (s + e) / 2, l, r);
		int rMin = min(arr, node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		return Math.min(lMin, rMin);
	}
	
	public void update(int[] arr, int node, int s, int e, int idx, int num) {
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
		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}
}