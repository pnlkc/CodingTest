import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[Math.max(5, n + 1)];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 1;

		for (int i = 5; i <= n; i++) {
			if (dp[i - 1] == 2 || dp[i - 3] == 2 || dp[i - 4] == 2) {
				dp[i] = 1;
			} else {
				dp[i] = 2;
			}
		}

		if (dp[n] % 2 == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}