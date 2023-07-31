import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][][] dp = new int[n][3][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (i == 0) {
				dp[i][0][0] = r;
				dp[i][1][1] = g;
				dp[i][2][2] = b;
			} else if (i == n - 1) {	
				int r01 = calc(dp, i - 1, 0, 0, 2);
				int r02 = calc(dp, i - 1, 0, 0, 1);
				int r10 = calc(dp, i - 1, 1, 1, 2);
				int r12 = calc(dp, i - 1, 1, 0, 1);
				int r20 = calc(dp, i - 1, 2, 1, 2);
				int r21 = calc(dp, i - 1, 2, 0, 2);
				if (r01 != 0) dp[i][0][1] = g + r01;
				if (r02 != 0) dp[i][0][2] = b + r02;
				if (r10 != 0) dp[i][1][0] = r + r10;
				if (r12 != 0) dp[i][1][2] = b + r12;
				if (r20 != 0) dp[i][2][0] = r + r20;
				if (r21 != 0) dp[i][2][1] = g + r21;
			} else {
				int r00 = calc(dp, i - 1, 0, 1, 2);
				int r01 = calc(dp, i - 1, 0, 0, 2);
				int r02 = calc(dp, i - 1, 0, 0, 1);
				int r10 = calc(dp, i - 1, 1, 1, 2);
				int r11 = calc(dp, i - 1, 1, 0, 2);
				int r12 = calc(dp, i - 1, 1, 0, 1);
				int r20 = calc(dp, i - 1, 2, 1, 2);
				int r21 = calc(dp, i - 1, 2, 0, 2);
				int r22 = calc(dp, i - 1, 2, 0, 1);
				if (r00 != 0) dp[i][0][0] = r + r00;
				if (r01 != 0) dp[i][0][1] = g + r01;
				if (r02 != 0) dp[i][0][2] = b + r02;
				if (r10 != 0) dp[i][1][0] = r + r10;
				if (r11 != 0) dp[i][1][1] = g + r11;
				if (r12 != 0) dp[i][1][2] = b + r12;
				if (r20 != 0) dp[i][2][0] = r + r20;
				if (r21 != 0) dp[i][2][1] = g + r21;
				if (r22 != 0) dp[i][2][2] = b + r22;
			}
		}

		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (dp[n - 1][i][j] == 0) continue;
				min = Math.min(min, dp[n - 1][i][j]);
			}
		}
		
		System.out.println(min);
	}
	
	public static int calc(int[][][] dp, int i, int j, int k1, int k2) {
		if (dp[i][j][k1] == 0 && dp[i][j][k2] == 0) {
			return 0;
		} else if (dp[i][j][k1] == 0) {
			return dp[i][j][k2];
		} else if (dp[i][j][k2] == 0) {
			return dp[i][j][k1];
		} else {
			return Math.min(dp[i][j][k1], dp[i][j][k2]);
		}
	}
}