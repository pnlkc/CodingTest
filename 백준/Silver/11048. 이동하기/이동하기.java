import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, -1, 0 };
	static int[] dy = { 0, -1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int d = 0; d < 3; d++) {
					int nx = j + dx[d];
					int ny = i + dy[d];
					
					if (nx < 0 || ny < 0) {
						continue;
					}
					
					dp[i][j] = Math.max(dp[i][j], dp[ny][nx] + map[i][j]);
				}
			}
		}
		
		System.out.println(dp[N - 1][M - 1]);
	}
}