import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N, cnt;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			cnt = 0;

			calc(0, arr);
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

	public static void calc(int i, int[][] arr) {
		if (i == N) {
			cnt++;
		} else {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					check(j, i, 1, arr);
					calc(i + 1, arr);
					check(j, i, -1, arr);
				}
			}
		}
	}

	public static void check(int x, int y, int num, int[][] arr) {
		arr[y][x] += num;
		
		for (int j = 1; j < N; j++) {
			for (int d = 0; d < 3; d++) {
				int nx = x + dx[d] * j;
				int ny = y + dy[d] * j;
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				
				arr[ny][nx] += num;
			}
		}
	}
}