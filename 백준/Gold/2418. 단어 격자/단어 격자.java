import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		long[][][] dp = new long[H][W][L + 1];

		for (int i = 0; i < H; i++) {
			String str = br.readLine();

			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		String target = br.readLine();
		int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 };
		int[] dy = { 1, 0, -1, 1, 0, -1, -1, 1 };

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == target.charAt(0)) {
					dp[i][j][1] = 1;
				}
			}
		}
		
		for (int k = 1; k < L; k++) {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == target.charAt(k)) {
						for (int d = 0; d < 8; d++) {
							int nx = j + dx[d];
							int ny = i + dy[d];
							
							if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
							
							if (map[ny][nx] != target.charAt(k - 1)) continue;
						
							dp[i][j][k + 1] += dp[ny][nx][k];
						}
					}
				}
			}
		}
		
		long answer = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == target.charAt(L - 1)) {
					answer += dp[i][j][L];
				}
			}
		}
		
		System.out.println(answer);
	}
}