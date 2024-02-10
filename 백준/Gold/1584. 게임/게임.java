import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[501][501];
		int N = Integer.parseInt(br.readLine());
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			
			for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); x++) {
				for (int y = Math.min(Y1, Y2); y <= Math.max(Y1, Y2); y++) {
					map[y][x] = 1;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			
			for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); x++) {
				for (int y = Math.min(Y1, Y2); y <= Math.max(Y1, Y2); y++) {
					map[y][x] = 2;
				}
			}
		}
		
		Queue<Pos> q = new LinkedList<>();
		int[][] isVisit = new int[501][501];
		
		for (int i = 0; i < 501; i++) {
			for (int j = 0; j < 501; j++) {
				isVisit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		q.add(new Pos(0, 0, 0));
		isVisit[0][0] = 0;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			if (isVisit[c.y][c.x] < c.n) {
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx > 500 || ny > 500) {
					continue;
				}
				
				if (map[ny][nx] == 2) {
					continue;
				} else if (map[ny][nx] == 1) {
					if (isVisit[ny][nx] > c.n + 1) {
						isVisit[ny][nx] = c.n + 1;
						q.add(new Pos(nx, ny, c.n + 1));
					}
				} else {
					if (isVisit[ny][nx] > c.n) {
						isVisit[ny][nx] = c.n;
						q.add(new Pos(nx, ny, c.n));
					}
				}
			}
		}
		
		if (isVisit[500][500] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(isVisit[500][500]);
		}
	}
}

class Pos {
	int x, y, n;

	public Pos(int x, int y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
}