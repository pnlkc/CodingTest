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
		long[][] dp = new long[n][m];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1L;
		}

		for (int i = 0; i < m; i++) {
			dp[0][i] = 1L;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1]) % NUM;
			}
		}

		System.out.println(dp[n - 1][m - 1]);
	}
}