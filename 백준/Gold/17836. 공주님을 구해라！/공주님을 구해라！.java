import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Pos> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[N][M];
		boolean[][] hasSwordIsVisit = new boolean[N][M];

		q.offer(new Pos(0, 0, 0, false));
		isVisit[0][0] = true;

		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			if (c.x == M - 1 && c.y == N - 1) {
				System.out.println(c.time);
				return;
			} else if (c.time > T) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if (!c.hasSword && isVisit[ny][nx]) continue;
				if (c.hasSword && hasSwordIsVisit[ny][nx]) continue;
				
				
				if (map[ny][nx] == 0) {
					q.offer(new Pos(nx, ny, c.time + 1, c.hasSword));
					
					if (!c.hasSword) isVisit[ny][nx] = true;
					else hasSwordIsVisit[ny][nx] = true;
				} else if (map[ny][nx] == 1) {
					if (c.hasSword) {
						q.offer(new Pos(nx, ny, c.time + 1, true));
						hasSwordIsVisit[ny][nx] = true;
					}
				} else {
					q.offer(new Pos(nx, ny, c.time + 1, true));
					isVisit[ny][nx] = true;					
					hasSwordIsVisit[ny][nx] = true;					
				}
			}
		}
		
		System.out.println("Fail");
	}
}

class Pos {
	int x, y, time;
	boolean hasSword;

	public Pos(int x, int y, int time, boolean hasSword) {
		this.x = x;
		this.y = y;
		this.time = time;
		this.hasSword = hasSword;
	}
}