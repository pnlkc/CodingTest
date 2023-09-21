import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int x, y, d;

	public Node(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();

				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int[][] dist = new int[N][N];
			PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.d - n2.d);
			pq.add(new Node(0, 0, 0));

			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], -1);
			}
			dist[0][0] = 0;
			
			while (!pq.isEmpty()) {
				Node c = pq.poll();
				if (c.x == N - 1 && c.y == N - 1) {
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nx = c.x + dx[d];
					int ny = c.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					
					if (dist[ny][nx] == -1 || dist[ny][nx] > dist[c.y][c.x] + map[ny][nx]) {
						dist[ny][nx] = dist[c.y][c.x] + map[ny][nx];
						pq.add(new Node(nx, ny, dist[ny][nx]));
					}
				}
			}

			System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
		}
	}
}