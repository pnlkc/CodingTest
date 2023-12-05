import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			dp[i][0] = dp[i - 1][0] + num;
			
			if (dp[i][0] < num) {
				dp[i][0] = num;
			}
			
			dp[i][1] = Math.max(dp[i - 1][1] + num, dp[i - 1][0]);
		}
		
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				max = Math.max(max, dp[i][0]);				
			} else {
				max = Math.max(max, Math.max(dp[i][0], dp[i][1]));				
			}
		}
        
		System.out.println(max);
	}
}