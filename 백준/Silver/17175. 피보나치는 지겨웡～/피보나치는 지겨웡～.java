import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int NUM = 1_000_000_007;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[Math.max(3, N + 1)];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + 1) % NUM;
		}
		
		System.out.println(dp[N]);
	}
}