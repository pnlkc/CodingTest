import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y, d, keys;

	public Pos() {
	}

	public Pos(int x, int y, int d, int keys) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.keys = keys;
	}
}

public class Main {
	static int N, M, result;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Pos start = new Pos();
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == '0') {
					start = new Pos(j, i, 0, 0);
				}
			}
		}

		move(start, new boolean[N][M][64]);

		System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
	}

	public static void move(Pos p, boolean[][][] isVisit) {
		if (p.d >= result) {
			return;
		}

		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		isVisit[p.y][p.x][p.keys] = true;

		while (!q.isEmpty()) {
			Pos c = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}

				if (map[ny][nx] == '#')
					continue;
				if (isVisit[ny][nx][c.keys])
					continue;

				
				if (Character.isUpperCase(map[ny][nx])) { // 문을 만난 경우
					if ((c.keys & (1 << (map[ny][nx] - 'A'))) != 0) {
						isVisit[ny][nx][c.keys] = true;
						q.add(new Pos(nx, ny, c.d + 1, c.keys));
					}
				} else if (Character.isLowerCase(map[ny][nx])) { // 열쇠를 만난 경우
					if ((c.keys & (1 << (map[ny][nx] - 'a'))) == 0) {
						isVisit[ny][nx][c.keys | (1 << (map[ny][nx] - 'a'))] = true;
						q.add(new Pos(nx, ny, c.d + 1, (c.keys | (1 << (map[ny][nx] - 'a')))));
					} else {
						isVisit[ny][nx][c.keys] = true;
						q.add(new Pos(nx, ny, c.d + 1, c.keys));
					}
				} else if (map[ny][nx] == '1') { // 출구를 만난 경우
					result = Math.min(result, c.d + 1);
				} else {
					isVisit[ny][nx][c.keys] = true;
					q.add(new Pos(nx, ny, c.d + 1, c.keys));
				}
			}
		}
	}
}