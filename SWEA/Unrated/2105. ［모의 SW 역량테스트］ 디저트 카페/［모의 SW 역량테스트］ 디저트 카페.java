import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { 1, 1, -1, -1 };
	static int[][] map;
	static Stack<Integer> pick;
	static int N, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			pick = new Stack<>();
			max = -1;

			// 지도 생성
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					pick.push(map[i][j]);
					calc(j, i, j, i, 0);
					pick.pop();
				}
			}
			
			System.out.println("#" + + tc + " " + max);
		}
	}
	
	public static void calc(int x, int y, int sx, int sy, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			if (sx == nx && sy == ny) {
				max = Math.max(max, pick.size());
			} else if (!pick.contains(map[ny][nx])) {
				pick.push(map[ny][nx]);
				calc(nx, ny, sx, sy, dir);
				pick.pop();
			}
		}
		
		if (dir < 3) {
			int newDir = dir + 1;
			
			nx = x + dx[newDir];
			ny = y + dy[newDir];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (sx == nx && sy == ny) {
					max = Math.max(max, pick.size());
				} else if (!pick.contains(map[ny][nx])) {
					pick.push(map[ny][nx]);
					calc(nx, ny, sx, sy, newDir);
					pick.pop();
				}
			}
		}
	}
}