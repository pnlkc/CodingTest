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
				
		STree sTree = new STree(N);
		sTree.init(arr, 1, 1, N);
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			Data r = sTree.calc(1, 1, N, a, b);
			
			sb.append(r.min + " " + r.max + "\n");
		}
		
		System.out.println(sb);
	}
}

class Data {
	int min, max;

	public Data(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

class STree {
	Data[] tree;
	
	public STree(int n) {
		int h = ((int) (Math.log(n) / Math.log(2))) + 1;
		int cnt = (int) Math.pow(2, h + 1);
		tree = new Data[cnt + 1];
	}
	
	void init(int[] arr, int node, int s, int e) {
		if (s == e) {
			tree[node] = new Data(arr[s], arr[s]);
		} else {
			init(arr, node * 2, s, (s + e) / 2);
			init(arr, node * 2 + 1, (s + e) / 2 + 1, e);
			tree[node] = new Data(Math.min(tree[node * 2].min, tree[node * 2 + 1].min), Math.max(tree[node * 2].max, tree[node * 2 + 1].max));
		}
	}
	
	Data calc(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return new Data(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		
		if (l <= s && r >= e) {
			return tree[node];
		}
		
		Data lData = calc(node * 2, s, (s + e) / 2, l, r);
		Data rData = calc(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		
		return new Data(Math.min(lData.min, rData.min), Math.max(lData.max, rData.max));
	}
}