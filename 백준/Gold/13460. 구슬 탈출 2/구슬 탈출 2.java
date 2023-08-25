import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int y, int x) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}
}

public class Main {
	static int N, M;
	static int num = 11;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		int[][] map = new int[N][M];
		Pos r = null;
		Pos b = null;

		// 보드판 초기화
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				if (c == '#') {
					map[i][j] = 1;
				} else if (c == '.') {
					map[i][j] = 0;
				} else if (c == 'O') {
					map[i][j] = 2;
				} else if (c == 'R') {
					r = new Pos(i, j);
					map[i][j] = 3;
				} else {
					b = new Pos(i, j);
					map[i][j] = 4;
				}
			}
		}

		move(map, r, b, 1);

		if (num > 10)
			System.out.println(-1);
		else
			System.out.println(num);
	}

	public static void move(int[][] map, Pos r, Pos b, int cnt) {
		if (num <= cnt) return;
		
		for (int d = 0; d < 4; d++) {
			int[][] tMap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
			int rx = r.x * dx[d];
			int ry = r.y * dy[d];
			int bx = b.x * dx[d];
			int by = b.y * dy[d];
			Pos[] arr = new Pos[2];
			Pos nr = r;
			Pos nb = b;

			if ((rx == bx && ry > by) || (ry == by && rx > bx)) {
				arr[0] = r;
				arr[1] = b;
			} else {
				arr[0] = b;
				arr[1] = r;
			}

			for (int i = 0; i < 2; i++) {
				Pos c = arr[i];
				
				int nx = c.x;
				int ny = c.y;
				
				// 빈공간이면 계속 이동
				while (nx + dx[d] >= 0 && nx + dx[d] < M && ny + dy[d] >= 0 && ny + dy[d] < N && tMap[ny + dy[d]][nx + dx[d]] == 0) {
					nx += dx[d];
					ny += dy[d];
				}
				
				// r, b의 새로운 좌표 갱신
				if (map[c.y][c.x] == 3) {
					nr = new Pos(ny, nx);
				} else if (map[c.y][c.x] == 4) {
					nb = new Pos(ny, nx);
				}
				
				tMap[ny][nx] = tMap[c.y][c.x];
				if (ny != c.y || nx != c.x) tMap[c.y][c.x] = 0;

				// 다음 칸이 구멍인 경우
				if (nx + dx[d] >= 0 && nx + dx[d] < M && ny + dy[d] >= 0 && ny + dy[d] < N && tMap[ny + dy[d]][nx + dx[d]] == 2) {
					if (map[c.y][c.x] == 3) {
						nr = new Pos(-1, -1);
					} else if (map[c.y][c.x] == 4) {
						nb = new Pos(-1, -1);
					}
					tMap[ny][nx] = 0;
				} 
			}
			
			if (check(nr, nb)) {
				num = cnt;
				return;
			} else {
				if (nb.x != -1 && nb.y != -1) {
					move(tMap, nr, nb, cnt + 1);
				}
			}
		}
	}
	
	public static boolean check(Pos r, Pos b) {
		if (r.x == -1 && r.y == -1 && b.x != -1 && b.y != -1) {
			return true;
		} else {
			return false;
		}
	}
}