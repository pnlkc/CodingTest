import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[Math.max(4, n + 1)];
		
		dp[1] = 1L;
		dp[2] = 1L;
		dp[3] = 1L;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}
		
		System.out.println(dp[n]);
	}
}