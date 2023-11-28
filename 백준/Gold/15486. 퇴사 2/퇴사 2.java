import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if (i + t - 1 <= N) {
				dp[i + t - 1] = Math.max(dp[i + t - 1], dp[i - 1] + p);		
			}
			
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		
		System.out.println(dp[N]);
	}

}