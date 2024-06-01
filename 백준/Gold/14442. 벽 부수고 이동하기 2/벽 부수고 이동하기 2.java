import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][][] isVisit = new int[N][M][K + 1];
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k <= K; k++) {
					isVisit[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		Queue<Pos> q = new LinkedList<>();

		q.offer(new Pos(0, 0, 1, 0));
		isVisit[0][0][0] = 1;

		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			if (c.x == M - 1 && c.y == N - 1) {
				result = Math.min(result, c.time);
			}
			if (c.time > result) continue;
			if (isVisit[c.y][c.x][c.cnt] < c.time) continue;
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				
				if (map[ny][nx] == 0) {
					if (isVisit[ny][nx][c.cnt] <= c.time + 1) continue;
					
					q.offer(new Pos(nx, ny, c.time + 1, c.cnt));
					isVisit[ny][nx][c.cnt] = c.time + 1;
				} else {
					if (c.cnt + 1 > K) continue;
					if (isVisit[ny][nx][c.cnt + 1] <= c.time + 1) continue;
					
					q.offer(new Pos(nx, ny, c.time + 1, c.cnt + 1));
					isVisit[ny][nx][c.cnt + 1] = c.time + 1;
				}
			}

		}

		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}

class Pos {
	int x, y, time, cnt;

	public Pos(int x, int y, int time, int cnt) {
		this.x = x;
		this.y = y;
		this.time = time;
		this.cnt = cnt;
	}
}