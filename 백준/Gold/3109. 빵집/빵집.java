import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, result = 0;
	static char[][] map;
	static int[] dx = { 1, 1, 1 };
	static int[] dy = { -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		boolean[][] isVisit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			if (dfs(new Pos(0, i), isVisit)) {
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean dfs(Pos p, boolean[][] isVisit) {
		isVisit[p.y][p.x] = true;

		if (p.x == C - 1) {
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int nx = p.x + dx[d];
			int ny = p.y + dy[d];
			
			if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
				continue;
			}
			
			if (map[ny][nx] == 'x') {
				continue;
			}
			
			if (isVisit[ny][nx]) {
				continue;
			}
			
			if (dfs(new Pos(nx, ny), isVisit)) {
				return true;
			}
		}
		
		return false;
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}