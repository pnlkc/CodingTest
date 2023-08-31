import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 1;
		
		calc(N, dp);
		System.out.println(dp[N - 1]);
	}
	
	public static int calc(int num, int[] dp) {
		if (num == 1) {
			return 1;
		}
		
		if (dp[num] != 0) {
			return dp[num];
		}
		
		for (int i = 1; i <= num / 2; i++) {
			int r1 = calc(i, dp);
			int r2 = calc(num - i, dp);
			dp[num] = Math.max(dp[num], r1 + r2 + (i * (num - i)));
		}
		
		return dp[num];
	}
}