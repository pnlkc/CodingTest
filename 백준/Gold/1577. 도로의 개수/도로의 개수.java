import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class No {
	int x1, y1, x2, y2;

	public No(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(br.readLine());
		No[] arr = new No[K];
		long[][] dp = new long[M + 1][N + 1];
		dp[0][0] = 1;
		int[] dx = { 1, 0 };
		int[] dy = { 0, 1 };

		for (int i = 0; i < K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st2.nextToken());
			int y1 = Integer.parseInt(st2.nextToken());
			int x2 = Integer.parseInt(st2.nextToken());
			int y2 = Integer.parseInt(st2.nextToken());

			arr[i] = new No(x1, y1, x2, y2);
		}
		
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(0, 0));
		
		while (!queue.isEmpty()) {
			Pos c = queue.poll();
			
			for (int d = 0; d < 2; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx > N || ny > M) {
					continue;
				}
				
				if (!check(c.x, c.y, nx, ny, arr)) {
					continue;
				}
				
				if (dp[ny][nx] == 0) {
					queue.add(new Pos(nx, ny));
				}
				
				dp[ny][nx] += dp[c.y][c.x];
			}
		}

		System.out.println(dp[M][N]);
	}

	public static boolean check(int x1, int y1, int x2, int y2, No[] arr) {
		for (int i = 0; i < arr.length; i++) {
			No c = arr[i];
			if (x1 == c.x1 && x2 == c.x2 && y1 == c.y1 && y2 == c.y2) {
				return false;
			}

			if (x2 == c.x1 && x1 == c.x2 && y2 == c.y1 && y1 == c.y2) {
				return false;
			}
		}

		return true;
	}
}