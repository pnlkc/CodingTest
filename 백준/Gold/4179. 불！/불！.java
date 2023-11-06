import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static Queue<Pos> fire;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Pos s = new Pos(-1, -1);
		fire = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();

			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'J') {
					s = new Pos(j, i);
					map[i][j] = '.';
				} else if (map[i][j] == 'F') {
					fire.offer(new Pos(j, i));
				}
			}
		}

		Queue<Pos> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[R][C];
		q.add(s);
		isVisit[s.y][s.x] = true;

		int ct = 0;

		while (!q.isEmpty()) {
			Pos c = q.poll();

			if (c.t > ct) {
				move();
				ct++;
			}

			if (map[c.y][c.x] == 'F') {
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
					System.out.println(c.t + 1);
					return;
				}

				if (map[ny][nx] != '.') {
					continue;
				}

				if (isVisit[ny][nx]) {
					continue;
				}

				isVisit[ny][nx] = true;
				q.add(new Pos(nx, ny, c.t + 1));
			}
		}

		System.out.println("IMPOSSIBLE");
	}

	public static void move() {
		Queue<Pos> temp = new LinkedList<>();

		while (!fire.isEmpty()) {
			Pos c = fire.poll();

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
					continue;
				}

				if (map[ny][nx] == '.') {
					map[ny][nx] = 'F';
					temp.offer(new Pos(nx, ny));
				}
			}
		}
		
		fire = temp;
	}
}

class Pos {
	int x, y, t;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pos(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}