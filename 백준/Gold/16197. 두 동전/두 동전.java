import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Queue<Pos> q = new LinkedList<>();
		int[] arr = { -1, -1, -1, -1 };
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'o') {
					if (arr[0] == -1) {
						arr[0] = j;
						arr[1] = i;
					} else {
						arr[2] = j;
						arr[3] = i;
					}
				}
			}
		}
		
		boolean[][][][] isVisit = new boolean[N][M][N][M];
		q.offer(new Pos(arr[0], arr[1], arr[2], arr[3], 0));
		isVisit[arr[1]][arr[0]][arr[3]][arr[2]] = true;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			if (c.t == 10) {
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx1 = c.x1 + dx[d];
				int ny1 = c.y1 + dy[d];
				int nx2 = c.x2 + dx[d];
				int ny2 = c.y2 + dy[d];
				boolean e1 = false;
				boolean e2 = false;
				
				if (nx1 < 0 || ny1 < 0 || nx1 >= M || ny1 >= N) {
					e1 = true;
				}
				
				if (nx2 < 0 || ny2 < 0 || nx2 >= M || ny2 >= N) {
					e2 = true;
				}
				
				if (e1 && e2) {
					continue;
				} else if (e1 || e2) {
					System.out.println(c.t + 1);
					return;
				}
				
				if (map[ny1][nx1] == '#') {
					nx1 = c.x1;
					ny1 = c.y1;
				}
				
				if (map[ny2][nx2] == '#') {
					nx2 = c.x2;
					ny2 = c.y2;
				}
				
				if (isVisit[ny1][nx1][ny2][nx2]) {
					continue;
				}
				
				isVisit[ny1][nx1][ny2][nx2] = true;
				q.offer(new Pos(nx1, ny1, nx2, ny2, c.t + 1));
			}
		}
		
		System.out.println(-1);
	}
}

class Pos {
	int x1, y1, x2, y2, t;

	public Pos(int x1, int y1, int x2, int y2, int t) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.t = t;
	}
}