import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = "";

		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + 1];

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (num > 0) {
					num = 1;
				} else if (num < 0) {
					num = -1;
				} else {
					num = 0;
				}

				arr[i] = num;
			}
			
			ST sTree = new ST(N);
			sTree.init(arr, 1, 1, N);

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				if (a.equals("C")) {
					sTree.update(arr, 1, 1, N, b, c);
				} else {
					int result = sTree.calc(arr, 1, 1, N, b, c);
					
					if (result > 0) {
						sb.append('+');						
					} else if (result < 0) {
						sb.append('-');
					} else {
						sb.append(0);
					}
				}
			}

			sb.append("\n");
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

		tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}

	public int calc(int[] arr, int node, int s, int e, int l, int r) {
		if (r < s || l > e) {
			return 1;
		}

		if (l <= s && r >= e) {
			return tree[node];
		}

		int lTree = calc(arr, node * 2, s, (s + e) / 2, l, r);
		int rTree = calc(arr, node * 2 + 1, (s + e) / 2 + 1, e, l, r);

		return lTree * rTree;
	}

	public void update(int[] arr, int node, int s, int e, int idx, int num) {
		if (idx < s || e < idx) {
			return;
		}

		if (s == idx && e == idx) {
			if (num > 0) {
				tree[node] = 1;
			} else if (num < 0) {
				tree[node] = -1;
			} else {
				tree[node] = 0;
			}

			arr[idx] = num;
			return;
		}

		update(arr, node * 2, s, (s + e) / 2, idx, num);
		update(arr, node * 2 + 1, (s + e) / 2 + 1, e, idx, num);

		tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}
}