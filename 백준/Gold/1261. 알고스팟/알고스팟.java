import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.d - n2.d);
		pq.offer(new Node(0, 0));
		dist[0][0] = 0;

		while (!pq.isEmpty()) {
			Node c = pq.poll();
			
			if (c.x == M - 1 && c.y == N - 1) {
				System.out.println(c.d);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				
				if (map[ny][nx] == 1) {
					if (dist[ny][nx] > c.d + 1) {
						pq.offer(new Node(nx, ny, c.d + 1));
						dist[ny][nx] = c.d + 1;
					}
				} else {
					if (dist[ny][nx] > c.d) {
						pq.offer(new Node(nx, ny, c.d));
						dist[ny][nx] = c.d;
					}
				}
			}
		}
	}
}

class Node {
	int x, y, d;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.d = 0;
	}
	
	public Node(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}