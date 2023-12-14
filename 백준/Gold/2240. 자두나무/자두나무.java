import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[T + 1][W + 2][2];
		int max = 0;
		
		for (int i = 1; i <= T; i++) {
			int num = Integer.parseInt(br.readLine());
			
			for (int j = 1; j <= W + 1; j++) {
				if (num == 1) {
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][1] + 1);
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0] + 1);
					dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][1]);
					dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j - 1][0]);
				} else {
					if (i == 1 && j == 1) {
						continue;
					}
					
					dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j - 1][0] + 1);
					dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][1] + 1);
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0]);
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][1]);
				}
			}
		}
		
		for (int i = 1; i <= W + 1; i++) {
			max = Math.max(max, Math.max(dp[T][i][0], dp[T][i][1]));
		}
		
		System.out.println(max);
	}
}