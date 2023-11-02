import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		int[] dx = { -1, -1, 0 };
		int[] dy = { -1, 0, -1 };
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int[] r = new int[3];
				
				for (int d = 0; d < 3; d++) {
					int nx = j + dx[d];
					int ny = i + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
						r[d] = -1;
						continue;
					}
					
					if (map[ny][nx] == 0) {
						r[d] = 0;
						continue;
					}
					
					r[d] = dp[ny][nx];
				}
				
				int min = Math.min(r[0], Math.min(r[1], r[2]));
				
				if (min > 0 && map[i][j] == 1) {
					dp[i][j] = min + 1;
				} else if (map[i][j] == 1) {
					dp[i][j] = 1;
				}
				
				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(max * max);
	}
}