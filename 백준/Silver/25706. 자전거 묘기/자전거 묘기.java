import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N];
		dp[N - 1] = 1;
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N - 1; i >= 0; i--) {
			calc(i, N, arr, dp);
		}
		
		
		for (int i = 0; i < N; i++) {
			sb.append(dp[i] + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public static int calc(int n, int N, int[] arr, int[] dp) {
		if (n > N - 1) {
			return 0;
		}
		
		if (dp[n] != 0) return dp[n];
		
		dp[n] = calc(n + arr[n] + 1, N, arr, dp) + 1;
		return dp[n];
	}
}