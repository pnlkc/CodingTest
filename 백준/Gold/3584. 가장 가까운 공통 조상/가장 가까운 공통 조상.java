import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, H;
	static List<Integer>[] tree;
	static int[][] parent;
	static int[] depth;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (; tc > 0; tc--) {
			N = Integer.parseInt(br.readLine());
			tree = new ArrayList[N + 1];
			H = getH();
			depth = new int[N + 1];
			arr = new int[N + 1];
			parent = new int[N + 1][H];
			
			for (int i = 0; i <= N;i ++) {
				tree[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				tree[a].add(b);
				tree[b].add(a);
				arr[b] = a; 
			}
			
			init(1, 1, arr[1]);
			fillParent();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (depth[a] > depth[b]) {
				int temp = a;
				a = b;
				b = temp;
			}
			
			sb.append(lca(a, b) + "\n");
		}
		
		System.out.print(sb);
	}
	
	public static int getH() {
		return (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
	}
	
	public static void init(int c, int h, int p) {
		depth[c] = h;
		
		for (int next : tree[c]) {
			if (parent[next][0] != 0) {
				continue;
			}
			
			if (next != p) {
				init(next, h + 1, c);
				parent[next][0] = c;
			} else {
				if (parent[c][0] != p) {
					parent[c][0] = p;
					init(next, h - 1, arr[next]);
				}
			}
		}
	}
	
	public static void fillParent() {
		for (int i = 1; i < H; i++) {
			for (int j = 1; j < N + 1; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}
	
	public static int lca(int a, int b) {
		for (int i = H - 1; i >= 0; i--) {
			if (depth[b] - depth[a] >= (1 << i)) {
				b = parent[b][i];
			}
		}
		
		if (a == b) {
			return a;
		}
		
		for (int i = H - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}
}