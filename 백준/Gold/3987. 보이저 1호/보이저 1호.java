import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Map<Integer, Character> dirMap = new HashMap<>();
	static Map<Character, Integer> numDir = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int max = 0;
		char dir = 'L';
		char voyagerDir = 'X';
		initDir();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		st = new StringTokenizer(br.readLine());
		int PR = Integer.parseInt(st.nextToken()) - 1;
		int PC = Integer.parseInt(st.nextToken()) - 1;

		for (int s = 0; s < 4; s++) {
			int sx = PC + dx[s];
			int sy = PR + dy[s];

			if (sx < 0 || sy < 0 || sx >= M || sy >= N) {
				if (max == 0) {
					max = 1;
					dir = dirMap.get(s);
				}
				continue;
			}
			
			if (map[sy][sx] == 'C') {
				if (max == 0) {
					max = 1;
					dir = dirMap.get(s);
				}
				continue;
			}

			boolean[][][] isVisit = new boolean[N][M][4];
			Queue<Pos> q = new LinkedList<Pos>();
			
			if (map[sy][sx] == '/') {
				if (s == 0) {
					q.add(new Pos(sx, sy, 1, 2));
					isVisit[sy][sx][2] = true;
				} else if (s == 1) {
					q.add(new Pos(sx, sy, 1, 3));
					isVisit[sy][sx][3] = true;
				} else if (s == 2) {
					q.add(new Pos(sx, sy, 1, 0));
					isVisit[sy][sx][0] = true;
				} else {
					q.add(new Pos(sx, sy, 1, 1));
					isVisit[sy][sx][1] = true;
				}
			}

			if (map[sy][sx] == '\\') {
				if (s == 0) {
					q.add(new Pos(sx, sy, 1, 3));
					isVisit[sy][sx][3] = true;
				} else if (s == 1) {
					q.add(new Pos(sx, sy, 1, 2));
					isVisit[sy][sx][2] = true;
				} else if (s == 2) {
					q.add(new Pos(sx, sy, 1, 1));
					isVisit[sy][sx][1] = true;
				} else {
					q.add(new Pos(sx, sy, 1, 0));
					isVisit[sy][sx][0] = true;
				}
			}
			
			if (map[sy][sx] == '.') {
				q.add(new Pos(sx, sy, 1, s));
				isVisit[sy][sx][s] = true;
			}

			while (!q.isEmpty()) {
				Pos c = q.poll();

				int nx = c.x;
				int ny = c.y;
				
				if (c.dir == 0) {
					nx += 1;
				} else if (c.dir == 1) {
					nx -= 1;
				} else if (c.dir == 2) {
					ny -= 1;
				} else {
					ny += 1;
				}
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					if (max < c.n + 1) {
						max = c.n + 1;
						dir = dirMap.get(s);
					} else if (max == c.n + 1 && numDir.get(dir) < numDir.get(dirMap.get(s))) {
						dir = dirMap.get(s);
					}
					continue;
				}

				if (map[ny][nx] == 'C') {
					if (max < c.n + 1) {
						max = c.n + 1;
						dir = dirMap.get(s);
					} else if (max == c.n + 1 && numDir.get(dir) <  numDir.get(dirMap.get(s))) {
						dir = dirMap.get(s);
					}
					continue;
				}

				if (isVisit[ny][nx][c.dir]) {
					if (voyagerDir == 'X') {
						voyagerDir = dirMap.get(s);
					} else if (numDir.get(voyagerDir) < numDir.get(dirMap.get(s))) {
						voyagerDir = dirMap.get(s);
					}
					continue;
				}

				if (map[ny][nx] == '/') {
					if (c.dir == 0) {
						q.add(new Pos(nx, ny, c.n + 1, 2));
						isVisit[ny][nx][2] = true;
					} else if (c.dir == 1) {
						q.add(new Pos(nx, ny, c.n + 1, 3));
						isVisit[ny][nx][3] = true;
					} else if (c.dir == 2) {
						q.add(new Pos(nx, ny, c.n + 1, 0));
						isVisit[ny][nx][0] = true;
					} else {
						q.add(new Pos(nx, ny, c.n + 1, 1));
						isVisit[ny][nx][1] = true;
					}
					continue;
				}

				if (map[ny][nx] == '\\') {
					if (c.dir == 0) {
						q.add(new Pos(nx, ny, c.n + 1, 3));
						isVisit[ny][nx][3] = true;
					} else if (c.dir == 1) {
						q.add(new Pos(nx, ny, c.n + 1, 2));
						isVisit[ny][nx][2] = true;
					} else if (c.dir == 2) {
						q.add(new Pos(nx, ny, c.n + 1, 1));
						isVisit[ny][nx][1] = true;
					} else {
						q.add(new Pos(nx, ny, c.n + 1, 0));
						isVisit[ny][nx][0] = true;
					}
					continue;
				}

				q.add(new Pos(nx, ny, c.n + 1, c.dir));
				isVisit[ny][nx][c.dir] = true;
			}
		}
		
		if (voyagerDir != 'X') {
			System.out.println(voyagerDir);
			System.out.println("Voyager");
		} else {
			System.out.println(dir);
			System.out.println(max);
		}
	}

	public static void initDir() {
		dirMap.put(0, 'R');
		dirMap.put(1, 'L');
		dirMap.put(2, 'U');
		dirMap.put(3, 'D');
		
		numDir.put('U', 3);
		numDir.put('R', 2);
		numDir.put('D', 1);
		numDir.put('L', 0);
	}
}

class Pos {
	int x, y, n, dir;

	public Pos(int x, int y, int n, int dir) {
		this.x = x;
		this.y = y;
		this.n = n;
		this.dir = dir;
	}
}