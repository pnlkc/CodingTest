import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, time, result;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		next();
		
		if (result == 0) {
			System.out.println(0);
		} else {
			System.out.println(time);
		}
	}

	public static void next() {
		time++;
		
		int[][] temp = new int[N][M];
		copyMap(map, temp);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				
				int cnt = 0;
				
				for (int d = 0; d < 4; d++) {
					int nx = j + dx[d];
					int ny = i + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
						continue;
					}
					
					if (map[ny][nx] == 0) {
						cnt++;
					}
				}
				
				temp[i][j] -= cnt;
				if (temp[i][j] < 0) {
					temp[i][j] = 0;
				}
			}
		}
		
		map = temp;
		
		result = check();
		
		if (result == 1) {
			next();
		}
	}
	
	public static int check() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[N][M];
		
		p: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					q.add(new Pos(j, i));
					isVisit[i][j] = true;
					break p;
				}
			}
		}
		
		if (q.isEmpty()) { // 빙산이 다 녹을 때까지 분리 되지 않음
			return 0; 
		}
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				
				if (isVisit[ny][nx]) {
					continue;
				}
				
				if (map[ny][nx] == 0) {
					continue;
				}
				
				q.add(new Pos(nx, ny));
				isVisit[ny][nx] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !isVisit[i][j]) { // 빙산이 분리되는 경우
					return 2;
				}
			}
		}
		
		return 1; // 빙산이 분리되지 않은 경우
	}

	public static void copyMap(int[][] ori, int[][] dest) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dest[i][j] = ori[i][j];
			}
		}
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}