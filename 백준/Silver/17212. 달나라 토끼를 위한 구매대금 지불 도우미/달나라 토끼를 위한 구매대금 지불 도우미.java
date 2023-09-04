import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] arr = { 1, 2, 5, 7 };
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 4; j++) {
				if (i - arr[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}