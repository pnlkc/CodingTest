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
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N + 3000][M + 3000];
		Queue<Pos> q = new LinkedList<Pos>();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'o') {
					map[i + 1500][j + 1500] = true;
					q.add(new Pos(j + 1500, i + 1500, 0));
					cnt++;
				}
			}
		}

		int K = Integer.parseInt(br.readLine());

		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			if (c.t >= K) continue;

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= M + 3000 || ny >= N + 3000)
					continue;
				if (map[ny][nx])
					continue;

				map[ny][nx] = true;
				q.add(new Pos(nx, ny, c.t + 1));
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}

class Pos {
	int x, y, t;

	Pos(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}