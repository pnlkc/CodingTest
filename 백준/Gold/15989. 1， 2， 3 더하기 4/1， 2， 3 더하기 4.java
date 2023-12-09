import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[10001][3];
		
		dp[1] = new int[] { 1, 0, 0 };
		dp[2] = new int[] { 2, 1, 0 };
		dp[3] = new int[] { 3, 0, 1 };
		
		for (int i = 4; i < 10001; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][1] + dp[i - 2][2] + dp[i - 3][2];
			dp[i][1] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][2] = dp[i - 3][2]; 
		}
		
		
		for (int tc = 0; tc < T; tc++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][0] + "\n");
		}
		
		System.out.print(sb);
	}
}