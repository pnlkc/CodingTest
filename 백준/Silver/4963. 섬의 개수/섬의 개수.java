import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] isVisit;
	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			if (str.equals("0 0")) break;
			StringTokenizer st1 = new StringTokenizer(str);
			w = Integer.parseInt(st1.nextToken());
			h = Integer.parseInt(st1.nextToken());
			map = new int[h][w];
			isVisit = new boolean[h][w];
			int cnt = 0;
			
			for (int i = 0; i < h; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !isVisit[i][j]) {
						cnt++;
						dfs(j, i);
					}
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		isVisit[y][x] = true;
		
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
			if (isVisit[ny][nx]) continue;
			if (map[ny][nx] == 0) continue;
			
			dfs(nx, ny);
		}
	}
}