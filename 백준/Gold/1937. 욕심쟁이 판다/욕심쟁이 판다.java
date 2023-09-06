import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int n;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(j, i));
			}
		}
        
		System.out.println(max + 1);
	}

	public static int dfs(int x, int y) {
		if (dp[y][x] != 0) {
			return dp[y][x];
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if (map[ny][nx] <= map[y][x])
				continue;

			dp[y][x] = Math.max(dp[y][x], dfs(nx, ny) + 1);
		}
	
		return dp[y][x];
	}
}