import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			int[][] dp = new int[N + 1][M + 1];
			
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				
				int num1 = arr[i];
				
				while (num1 <= M) {
					dp[i][num1]++;
					num1 += arr[i];
				}
				
				for (int j = 1; j <= M; j++) {
					int num2 = 0;
					
					while (j + num2 <= M) {
						dp[i][j + num2] += dp[i - 1][j];
						num2 += arr[i];
					}
				}	
			}
			
			System.out.println(dp[N][M]);
		}
	}
}