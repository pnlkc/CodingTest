import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int BOX = 1_000_001;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[BOX];
		ST sTree = new ST();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == 1) {
				sb.append(sTree.eat(arr, 1, 1, BOX, B) + "\n");
			} else {
				int C = Integer.parseInt(st.nextToken());

				sTree.add(arr, 1, 1, BOX, B, C);
			}
		}

		System.out.print(sb);
	}
}

class ST {
	int[] tree;
	final int BOX = 1_000_001;

	public ST() {
		int h = (int) Math.ceil(Math.log(BOX) / Math.log(2));
		int cnt = (int) Math.pow(2, h + 1);
		tree = new int[cnt];
	}

	public int eat(int[] arr, int node, int s, int e, int num) {
		if (s == e) {
			add(arr, 1, 1, BOX, e, -1);
			return e;
		}
		
		if (tree[node * 2] >= num) {
			return eat(arr, node * 2, s, (s + e) / 2, num);
		} else {
			return eat(arr, node * 2 + 1, (s + e) / 2 + 1, e, num - tree[node * 2]);
		}
	}

	public void add(int[] arr, int node, int s, int e, int idx, int num) {
		if (idx < s || e < idx) {
			return;
		}

		if (s == idx && e == idx) {
			tree[node] += num;
			arr[idx] += num;
			return;
		}

		add(arr, node * 2, s, (s + e) / 2, idx, num);
		add(arr, node * 2 + 1, (s + e) / 2 + 1, e, idx, num);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}