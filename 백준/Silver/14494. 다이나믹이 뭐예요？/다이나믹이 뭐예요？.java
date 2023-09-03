import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int NUM = 1_000_000_007;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dx = { 1, 1, 0 };
		int[] dy = { 0, 1, 1 };
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < 3; d++) {
					int nx = j + dx[d];
					int ny = i + dy[d];
					
					if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
						continue;
					}
					
					dp[ny][nx] = (dp[ny][nx] + dp[i][j]) % NUM;
				}
			}
		}
		
		System.out.println(dp[n - 1][m - 1]);
	}
}