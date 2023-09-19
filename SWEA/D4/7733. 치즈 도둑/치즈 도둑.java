import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N, cnt;
	static int[][] map;
	static boolean[][] isVisit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int r = 1;
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			for (int day = 1; day < max; day++) {
				isVisit = new boolean[N][N];
				cnt = 0;
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!isVisit[i][j] && map[i][j] > day) {
							cnt++;
							dfs(new Pos(j, i), day);
						}
					}
				}
				
				r = Math.max(r, cnt);
			}
			
			System.out.println("#" + tc + " " + r);
		}
	}
	
	public static void dfs(Pos c, int day) {
		isVisit[c.y][c.x] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = c.x + dx[d];
			int ny = c.y + dy[d];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			if (map[ny][nx] <= day) continue;
			if (isVisit[ny][nx]) continue;
			
			isVisit[ny][nx] = true;
			dfs(new Pos(nx, ny), day);
		}
	}
}