import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[1_000_001][9];
		int[] arr = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10 };

		init(dp, arr);

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()) / 10 * 10;
			
			sb.append("#" + tc + "\n");
			
			for (int i = 0; i < 8; i++) {
				sb.append(dp[N][i]);
				
				if (i != 7)  {
					sb.append(" ");
				} else {
					sb.append("\n");
				}
			}
		}
		
		System.out.print(sb);
	}

	public static void init(int[][] dp, int[] arr) {
		for (int i = 0; i < 8; i++) {
			dp[arr[i]] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
			dp[arr[i]][i] = 1;
		}

		for (int i = 0; i <= 1_000_000; i++) {
			for (int j = 0; j < 8; j++) {
				if (i - arr[j] >= 0 && dp[i - arr[j]][8] != 0) {
					if (dp[i][8] == 0) {
						dp[i] = Arrays.copyOf(dp[i - arr[j]], 9);
						dp[i][j]++;
						dp[i][8]++;
					} else {
						if (dp[i][8] > dp[i - arr[j]][8] + 1) {
							dp[i] = Arrays.copyOf(dp[i - arr[j]], 9);
							dp[i][j]++;
							dp[i][8]++;
						}
					}
				}
			}
		}
	}
}