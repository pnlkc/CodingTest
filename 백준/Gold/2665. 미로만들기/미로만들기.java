import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] isVisit = new boolean[n][n];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>((Pos p1, Pos p2) -> p1.d - p2.d);
		pq.offer(new Pos(0, 0, 0));
		isVisit[0][0] = true;
		
		while(!pq.isEmpty()) {
			Pos c = pq.poll();
			
			if (c.x == n - 1 && c.y == n - 1) {
				System.out.println(c.d);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if (isVisit[ny][nx]) {
					continue;
				}
				
				isVisit[ny][nx] = true;
				
				if (map[ny][nx] == 0) {
					pq.add(new Pos(nx, ny, c.d + 1));
				} else {
					pq.add(new Pos(nx, ny, c.d));
				}
			}
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