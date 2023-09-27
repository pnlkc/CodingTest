import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 0; i <= N; i++) {
			if (dp[i] == Integer.MAX_VALUE) continue;
			
			if (i + 3 <= N) {
				dp[i + 3] = Math.min(dp[i + 3], dp[i] + 1);
			}
			
			if (i + 5 <= N) {
				dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
			}
		}
		
		if (dp[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}
}