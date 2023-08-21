import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Data {
	int x, y, d, k;

	public Data(int x, int y, int d, int k) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.k = k;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st1.nextToken());
		int H = Integer.parseInt(st1.nextToken());
		int[][] map = new int[H][W];
		int[][][] dp = new int[H][W][K + 1];
		int[] dx1 = { 1, -1, 0, 0 };
		int[] dy1 = { 0, 0, 1, -1 };
		int[] dx2 = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] dy2 = { 1, -1, 2, -2, 2, -2, 1, -1 };

		if (W == 1 && H == 1) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < H; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				return o1.d - o2.d;
			}
		});

		pq.add(new Data(0, 0, 0, 0));
		
		while (!pq.isEmpty()) {
			Data c = pq.poll();
			
			if (c.x == W - 1 && c.y == H - 1) {
				System.out.println(c.d);
				return;
			}

			if (dp[c.y][c.x][c.k] != 0 && dp[c.y][c.x][c.k] < c.d) {
				continue;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nx = c.x + dx1[dir];
				int ny = c.y + dy1[dir];

				if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
					continue;
				}

				if (map[ny][nx] == 1) {
					continue;
				}

				if (dp[ny][nx][c.k] == 0 || dp[ny][nx][c.k] > c.d + 1) {
					dp[ny][nx][c.k] = c.d + 1;
					pq.add(new Data(nx, ny, dp[ny][nx][c.k], c.k));
				}
			}

			if (c.k < K) {
				for (int dir = 0; dir < 8; dir++) {
					int nx = c.x + dx2[dir];
					int ny = c.y + dy2[dir];

					if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
						continue;
					}

					if (map[ny][nx] == 1) {
						continue;
					}

					if (dp[ny][nx][c.k + 1] == 0 || dp[ny][nx][c.k + 1] > c.d + 1) {
						dp[ny][nx][c.k + 1] = c.d + 1;
						pq.add(new Data(nx, ny, dp[ny][nx][c.k + 1], c.k + 1));
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}