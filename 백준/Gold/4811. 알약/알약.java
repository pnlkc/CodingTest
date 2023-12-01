import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = null;
		long[][] dp = new long[31][31];
		
		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (j == 0) {
					if (i == 1) {
						dp[i][j] += 1;						
					} else {
						dp[i][j] += dp[i - 1][j + 1];						
					}
				} else {
					if (i == 1) {
						dp[i][j] += dp[i][j - 1] + 1;
					} else {						
						dp[i][j] += dp[i][j - 1] + dp[i - 1][j + 1];
					}
				}
			}
		}
		
		while (!(str = br.readLine()).equals("0")) {
			int num = Integer.parseInt(str);
			sb.append(dp[num][0] + "\n");
		}
		
		System.out.print(sb);
	}
}