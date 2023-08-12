import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Pos[][] parent;
	static int[][] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		parent = new Pos[N][M];
		rank = new int[N][M];
		int cnt = 0;
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				parent[i][j] = new Pos(j, i);
			}
		}
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int idx = -1;
				if (map[i][j] == 'U') {
					idx = 0;
				} else if (map[i][j] == 'D') {
					idx = 1;
				} else if (map[i][j] == 'L') {
					idx = 2;
				} else if (map[i][j] == 'R') {
					idx = 3;
				}
				
				int nx = j + dx[idx];
				int ny = i + dy[idx];
//				System.out.println("c : " + map[i][j] + " / x : " + j + " / y : " + i + " / nx : " + nx + " / ny : " + ny);
				
				if (!union(new Pos(j, i), new Pos(nx, ny))) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static boolean union(Pos pos1, Pos pos2) {
		Pos p1 = find(pos1);
		Pos p2 = find(pos2);
		
		if (p1.x == p2.x && p1.y == p2.y) return false;
		
		if (rank[p1.y][p1.x] > rank[p2.y][p2.x]) {
			parent[p2.y][p2.x] = p1;
		} else if (rank[p1.y][p1.x] < rank[p2.y][p2.x]) {
			parent[p1.y][p1.x] = p2;
		} else {
			parent[p2.y][p2.x] = p1;
			rank[p1.y][p1.x]++;
		}
		
		return true;
	}
	
	public static Pos find(Pos p) {
		if (p.x != parent[p.y][p.x].x || p.y != parent[p.y][p.x].y) {
			return find(parent[p.y][p.x]);
		}
		return parent[p.y][p.x];
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}