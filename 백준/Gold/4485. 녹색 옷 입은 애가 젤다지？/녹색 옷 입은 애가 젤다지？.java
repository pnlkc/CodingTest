import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		int N = -1;
		
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			PriorityQueue<Pos> pq = new PriorityQueue<>((Pos p1, Pos p2) -> p1.d - p2.d);
			
			tc++;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			pq.offer(new Pos(0, 0, map[0][0]));
			dist[0][0] = map[0][0];
			
			while (!pq.isEmpty()) {
				Pos c = pq.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = c.x + dx[d];
					int ny = c.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					
					if (dist[ny][nx] <= c.d + map[ny][nx]) {
						continue;
					}
					
					dist[ny][nx] = c.d + map[ny][nx];
					pq.add(new Pos(nx, ny, dist[ny][nx]));
				}
			}
			
			System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);
		}
	}
}

class Pos {
	int x, y, d;

	public Pos(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}