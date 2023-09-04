import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int NUM =  1_000_000_000;
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[Math.max(2, Math.abs(n) + 1)];
		dp[0] = 0;
		dp[1] = 1;
		
		if (n < 0) {
			for (int i = 2; i <= Math.abs(n); i++) {
				dp[i] = (dp[i - 2] - dp[i - 1]) % NUM;
			}
		} else {
			for (int i = 2; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % NUM;
			}
		}
		
		if (dp[Math.abs(n)] < 0) {
			System.out.println(-1);
		} else if (dp[Math.abs(n)] > 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		System.out.println(Math.abs(dp[Math.abs(n)]));
	}
}