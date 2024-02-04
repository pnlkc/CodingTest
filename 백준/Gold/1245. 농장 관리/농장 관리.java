import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dx = { 1, -1, 1, -1, 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, -1, 1, 1, -1 };
	static int[][] map;
	static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisit = new boolean[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int num = 500; num >= 0; num--) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != num || isVisit[i][j])
						continue;

					dfs(j, i, num);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

	public static void dfs(int x, int y, int num) {
		isVisit[y][x] = true;

		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N)
				continue;

			if (map[ny][nx] > num)
				continue;
			
			if (map[y][x] < map[ny][nx])
				continue;
		
			if (isVisit[ny][nx])
				continue;
			
			isVisit[ny][nx] = true;
			dfs(nx, ny, num);
		}
	}
}