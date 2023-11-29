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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		H = getH();
		depth = new int[N + 1];
		parent = new int[N + 1][H];
		
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		init(1, 1, 0);
		fillParent();
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (depth[a] > depth[b]) { // 탐색을 하기전 b의 깊이가 a보다 깊도록 설정
				int temp = a;
				a = b;
				b = temp;
			}
			
			sb.append(lca(a, b) + "\n");
		}
		
		System.out.println(sb);
	}
	
	// 트리의 최대 높이를 구하는 메소드
	public static int getH() {
		return (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
	}
	
	// DFS를 사용해 각 노드의 depth와 바로 위의 부모 노드를 찾아 초기화 시켜주는 메소드
	public static void init(int c, int h, int p) {
		depth[c] = h; // 현재 노드 c의 depth 초기화
		
		for (int next : tree[c]) {
			if (next != p) { // 무한 루프에 빠지지 않게 하기 위한 조건
				init(next, h + 1, c); // 자식 노드에서 다시 탐색
				parent[next][0] = c; // 자식 노드의 부모로 자신을 입력해 초기화
			}
		}
	}
	
	// DP를 사용하여 각 노드의 2^i 제곱의 부모를 찾아 초기화 시켜주는 메소드 
	public static void fillParent() {
		for (int i = 1; i < H; i++) {
			for (int j = 1; j < N + 1; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}
	
	// LCA를 구하는 메소드
	public static int lca(int a, int b) {
		// a와 b의 높이를 동일하게 맞춰주는 과정
		// 2^N을 큰 숫자부터 감소시키며 탐색 (비트 연산을 사용)
		for (int  i = H - 1; i >= 0; i--) {
			if (depth[b] - depth[a] >= (1 << i)) {
				b = parent[b][i];
			}
		}
		
		if (a == b) { // a가 b의 조상인 경우
			return a; // a가 LCA이므로 a 반환
		}
		
		// LCA를 찾기 위해 거슬러 올라가는 과정
		for (int  i = H - 1; i >= 0; i--) { 
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0]; // LCA 반환
	}
}