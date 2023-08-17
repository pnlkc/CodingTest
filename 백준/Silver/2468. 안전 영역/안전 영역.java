import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int r = 1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < 100; i++) {
			int cnt = 0;
			isVisit = new boolean[N][N];
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!isVisit[j][k] && map[j][k] > i) {
						cnt++;
						dfs(k, j, i);
					}
				}
			}
		
			r = Math.max(r, cnt);
		}

		System.out.println(r);
	}

	public static void dfs(int x, int y, int h) {
		isVisit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if (map[ny][nx] <= h)
				continue;
			if (isVisit[ny][nx])
				continue;
			
			dfs(nx, ny, h);
		}
	}
}