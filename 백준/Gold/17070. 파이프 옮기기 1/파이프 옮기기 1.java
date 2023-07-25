import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) visit[i][j] = true;
			}
		}
		
		visit[0][0] = true;
		visit[0][1] = true;
		
		calc(visit, 0, 1, 0);
		
		System.out.println(cnt);
	}
	
	public static void calc(boolean[][] visit, int y, int x, int mode) {
		int lastIdx = visit.length - 1;
		if (y == lastIdx && x == lastIdx) {
			cnt++;
		} else {
			if (mode == 0) {
				// 가로 + 가로
				if (x + 1 <= lastIdx && !visit[y][x + 1]) {
					visit[y][x + 1] = true;
					calc(visit, y, x + 1, 0);
					visit[y][x + 1] = false;
				}
				
				// 가로 + 대각선
				if (x + 1 <= lastIdx && y + 1 <= lastIdx) {
					if (!visit[y][x + 1] && !visit[y + 1][x] && !visit[y + 1][x + 1]) {
						visit[y + 1][x] = true;
						visit[y][x + 1] = true;
						visit[y + 1][x + 1] = true;
						calc(visit, y + 1, x + 1, 2);
						visit[y + 1][x] = false;
						visit[y][x + 1] = false;
						visit[y + 1][x + 1] = false;
					}
				}
			} else if (mode == 1) {
				// 세로 + 세로
				if (y + 1 <= lastIdx && !visit[y + 1][x]) {
					visit[y + 1][x] = true;
					calc(visit, y + 1, x, 1);
					visit[y + 1][x] = false;
				}
				
				// 세로 + 대각선
				if (x + 1 <= lastIdx && y + 1 <= lastIdx) {
					if (!visit[y][x + 1] && !visit[y + 1][x] && !visit[y + 1][x + 1]) {
						visit[y + 1][x] = true;
						visit[y][x + 1] = true;
						visit[y + 1][x + 1] = true;
						calc(visit, y + 1, x + 1, 2);
						visit[y + 1][x] = false;
						visit[y][x + 1] = false;
						visit[y + 1][x + 1] = false;
					}
				}
			} else {
				// 대각선 + 가로
				if (x + 1 <= lastIdx && !visit[y][x + 1]) {
					visit[y][x + 1] = true;
					calc(visit, y, x + 1, 0);
					visit[y][x + 1] = false;
				}
				
				// 대각선 + 세로
				if (y + 1 <= lastIdx && !visit[y + 1][x]) {
					visit[y + 1][x] = true;
					calc(visit, y + 1, x, 1);
					visit[y + 1][x] = false;
				}
				
				// 대각선 + 대각선
				if (x + 1 <= lastIdx && y + 1 <= lastIdx) {
					if (!visit[y][x + 1] && !visit[y + 1][x] && !visit[y + 1][x + 1]) {
						visit[y + 1][x] = true;
						visit[y][x + 1] = true;
						visit[y + 1][x + 1] = true;
						calc(visit, y + 1, x + 1, 2);
						visit[y + 1][x] = false;
						visit[y][x + 1] = false;
						visit[y + 1][x + 1] = false;
					}
				}
			}
		}
	}
}