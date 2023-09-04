import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int NUM = 1_000_000_000;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][K + 1];
		
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		
		for (int i = 0; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				for (int k = i; k >= 0; k--) {
					dp[i][j] = (dp[i][j] + dp[k][j - 1]) % NUM;
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}