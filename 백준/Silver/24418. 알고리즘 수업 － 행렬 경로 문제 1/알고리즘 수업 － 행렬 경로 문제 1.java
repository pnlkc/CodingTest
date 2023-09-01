import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt1, cnt2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];
		cnt1 = 0;
		cnt2 = 0;
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		matrix_path_rec(map, n, n);
		matrix_path_dp(map, n, dp);
	
		System.out.println(cnt1 + " " + cnt2);
	}
	
	public static int matrix_path_rec(int[][] map, int i, int j) {
		if (i == 0 || j == 0) {
			cnt1++;
			return 0;
		}
		
		return map[i][j] + Math.max(matrix_path_rec(map, i - 1, j), matrix_path_rec(map, i, j - 1));
	}
	
	public static int matrix_path_dp(int[][] map, int n, int[][] dp) {
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		
		for (int j = 1; j <= n; j++) {
			dp[0][j] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				cnt2++;
				dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		return dp[n][n];
	}
}