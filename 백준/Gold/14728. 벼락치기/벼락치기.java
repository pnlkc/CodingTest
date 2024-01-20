import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][T + 1];
		int[] time = new int[N];
		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			time[i] = t;
			score[i] = s;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= T; j++) {
				if (j - time[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i - 1]] + score[i - 1]);
				}

				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}

		System.out.println(dp[N][T]);
	}
}