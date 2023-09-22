import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new boolean[101][101];
		int N = Integer.parseInt(br.readLine());
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			boolean[][] dragon = new boolean[101][101];
			dragon[y][x] = true;
			dragon[y + dy[d]][x + dx[d]] = true;

			rotate(x, y, x + dx[d], y + dy[d], dragon, 0, g);
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

	public static void rotate(int sx, int sy, int ex, int ey, boolean[][] dragon, int n, int g) {
		
		if (n == g) {
			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					if (dragon[i][j]) {
						map[i][j] = true;
					}
				}
			}
			return;
		}

		boolean[][] tmep = new boolean[101][101];
		
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (dragon[i][j]) {
					tmep[ey + (j - ex)][ex - (i - ey)] = true;
				}
			}
		}
		
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (tmep[i][j]) {
					dragon[i][j] = true;
				}
			}
		}

		rotate(sx, sy, ex - (sy - ey), ey + (sx - ex), dragon, n + 1, g);
	}
}