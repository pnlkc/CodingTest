import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		if (str.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		long[][] dp = new long[N][2];
		dp[0][0] = 1L;
		
		for (int i = 1; i < N; i++) {
			if (str.charAt(i) == '0' && Integer.parseInt(String.valueOf(str.charAt(i - 1))) > 2) {
				System.out.println(0);
				return;
			}
			
			String sum = String.valueOf(str.charAt(i - 1)) + String.valueOf(str.charAt(i));
			if (Integer.parseInt(sum) <= 26) {
				if (str.charAt(i) != '0') dp[i][0] += (dp[i - 1][0] + dp[i - 1][1]) % 1_000_000;
				dp[i][1] += dp[i - 1][0] % 1_000_000;
			} else {
				dp[i][0] += (dp[i - 1][0] + dp[i - 1][1]) % 1_000_000;
			}
		}
		
		System.out.println((dp[N - 1][0] + dp[N - 1][1]) % 1_000_000);
	}
}