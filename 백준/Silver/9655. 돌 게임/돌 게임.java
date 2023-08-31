import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		
		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[1] = 1;
			} else if (i == 2) {
				dp[2] = 2;
			} else {
				dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
			}
		}
		
		if (dp[N] % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}