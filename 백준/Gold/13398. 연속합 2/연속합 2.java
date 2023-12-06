import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][2]; // dp[i][0] : 숫자를 스킵하지 않은 경우, dp[i][1] : 숫자를 스킵한 경우
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 숫자를 스킵하지 않는 이전 누적합에 현재 숫자 더하기
			dp[i][0] = dp[i - 1][0] + num;
			
			if (dp[i][0] < num) { // 만약 현재까지의 숫자를 스킵하지 않는 이전 누적합보다 이번에 들어온 숫자가 더 큰 경우
				dp[i][0] = num;
			}
			
			// 숫자를 스킵하는 경우 최댓값
			dp[i][1] = Math.max(dp[i - 1][1] + num, dp[i - 1][0]);
		}
		
		for (int i = 1; i <= n; i++) {
			if (i == 1) { // dp[1][1]은 하나의 숫자도 고르지 않은 것이므로 제외하기 위한 조건
				max = Math.max(max, dp[i][0]);				
			} else {
				max = Math.max(max, Math.max(dp[i][0], dp[i][1]));				
			}
		}
		
		System.out.println(max);
	}
}