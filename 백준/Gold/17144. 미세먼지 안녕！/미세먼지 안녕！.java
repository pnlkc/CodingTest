import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] map;
	static int[] pos = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		T = Integer.parseInt(st1.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if (map[i][j] == -1 && pos == null) {
					pos = new int[] { i, j };
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			diffusion();
			purifier();
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) result += map[i][j]; 
			}
		}
		System.out.println(result);
	}
	
	public static void diffusion() {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int[][] temp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) { // 미세먼지가 있는 칸
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
						if (ny == pos[0] && nx == pos[1]) continue;
						if (ny == pos[0] + 1 && nx == pos[1]) continue;
						
						cnt++;
						temp[ny][nx] += map[i][j] / 5;
					}
					temp[i][j] += map[i][j] - (map[i][j] / 5 * cnt);
				}
			}
		}
		
		map = temp;
	}
	
	public static void purifier() {
		// 위쪽 반시계 방향
		int prev = 0;
		for (int i = 1; i < C; i++) {
			int temp = map[pos[0]][i];
			map[pos[0]][i] = prev;
			prev = temp;
		}
		
		for (int i = pos[0] - 1; i >= 0; i--) {
			int temp = map[i][C - 1];
			map[i][C - 1] = prev;
			prev= temp;
		}
		
		for (int i = C - 2; i >= 0; i--) {
			int temp = map[0][i];
			map[0][i] = prev;
			prev = temp;
		}
		
		for (int i = 1; i < pos[0]; i++) {
			int temp = map[i][0];
			map[i][0] = prev;
			prev = temp;
		}

		map[pos[0]][pos[1]] = -1;
		
		// 아래쪽 시계 방향
		prev = 0;
		for (int i = 1; i < C; i++) {
			int temp = map[pos[0] + 1][i];
			map[pos[0] + 1][i] = prev;
			prev = temp;
		}
				
		for (int i = pos[0] + 2; i < R; i++) {
			int temp = map[i][C - 1];
			map[i][C - 1] = prev;
			prev = temp;
		}
		
		for (int i = C - 2; i >= 0; i--) {
			int temp = map[R - 1][i];
			map[R - 1][i] = prev;
			prev = temp;
		}
		
		for (int i = R - 2; i > pos[0] + 1; i--) {
			int temp = map[i][0];
			map[i][0] = prev;
			prev= temp;
		}
		
		map[pos[0] + 1][pos[1]] = -1;
	}
}