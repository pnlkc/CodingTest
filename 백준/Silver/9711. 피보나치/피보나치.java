import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[10_001];

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			long Q = Long.parseLong(st.nextToken());
			
			dp[1] = 1L % Q;
			
			for (int i = 2; i <= P; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % Q;
			}
			
			sb.append("Case #" + tc + ": " + dp[P]).append("\n");
		}
		
		System.out.println(sb);
	}
}