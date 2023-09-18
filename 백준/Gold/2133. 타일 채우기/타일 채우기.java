import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[Math.max(3, N + 1)];
		
		dp[2] = 3;
		
		if (N % 2 != 0) {
			System.out.println(0);
		} else {
			for (int i = 4; i <= N; i += 2) {
				dp[i] = dp[i - 2] + 2;
				
				for (int j = i - 2; j >= 2; j -= 2) {
					dp[i] += dp[j] * 2;
				}
			}
			
			System.out.println(dp[N]);
		}
	}
}