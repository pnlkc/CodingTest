import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr, preSum, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < 3; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			preSum = new int[n + 1];
			dp = new int[n];
			
			// 배열 생성
			for (int i = n - 1; i >= 0; i--) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp, Integer.MAX_VALUE);
			
			// 누적합
			for (int i = 1; i <= n; i++) {
				preSum[i] = preSum[i - 1] + arr[i - 1];
			}
			
			int result = calc(0);
			
			if (result < 0) System.out.println("A");
			else if (result > 0) System.out.println("B");
			else System.out.println("D");
		}
	}
	
	public static int calc(int idx) {
		if (idx >= n) return 0;
		
		if (dp[idx] != Integer.MAX_VALUE) return dp[idx];
		
		for (int i = idx; i < n; i++) {
			dp[idx] = Math.min(dp[idx], preSum[i + 1] - preSum[idx] - calc(i + 1));
		}
		return dp[idx];
	}
}