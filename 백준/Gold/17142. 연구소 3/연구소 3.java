import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result, maxCnt;
	static int[] pick;
	static int[][] map;
	static List<Pos> vList = new ArrayList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		map = new int[N][N];
		pick = new int[M];
		result = -1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());

				if (map[i][j] == 2) {
					vList.add(new Pos(i, j));
				} else if (map[i][j] == 0) {
					maxCnt++;
				}
			}
		}

		pick(0, 0);

		System.out.println(result);
	}

	public static void pick(int idx, int cnt) {
		if (cnt == M) {
			int r = bfs(pick);

			if (r != -1 && result == -1) {
				result = r;
			} else if (r != -1 && result != -1) {
				result = Math.min(result, r);
			}

			return;
		}

		if (idx >= vList.size()) {
			return;
		}

		pick[cnt] = idx;
		pick(idx + 1, cnt + 1);
		pick(idx + 1, cnt);
	}

	public static int bfs(int[] sArr) {
		int cnt = 0;
		int r = 0;
		Queue<Pos> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[N][N];
		int[][] newMap = new int[N][N];

		for (int i : sArr) {
			Pos c = vList.get(i);
			q.add(c);
			isVisit[c.y][c.x] = true;
		}

		while (!q.isEmpty()) {
			Pos c = q.poll();
			if (map[c.y][c.x] == 0) {
				r = Math.max(r, c.d);
			}

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				if (map[ny][nx] == 1) {
					continue;
				}

				if (isVisit[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == 0) {
					cnt++;
				}
				
				if (result != -1 && r >= result) {
					return -1;
				}
				
				isVisit[ny][nx] = true;
				q.add(new Pos(ny, nx, c.d + 1));
				newMap[ny][nx] = c.d + 1;
			}
		}

		if (cnt == maxCnt) {
			return r;
		} else {
			return -1;
		}
	}
}

class Pos {
	int x, y, d;

	public Pos(int y, int x) {
		this.x = x;
		this.y = y;
	}

	public Pos(int y, int x, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}