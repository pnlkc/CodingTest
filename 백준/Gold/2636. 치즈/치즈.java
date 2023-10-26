import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, time;
	static int[][] map;
	static int[] dx = { 1, -1 ,0, 0 };
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
	}
	
	public static void next() {
		time++;
		
		int[][] temp = new int[N][M];
		copyMap(map, temp);
		
		boolean[][] isVisit = new boolean[N][M];
		Queue<Pos> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			isVisit[i][0] = true;
			isVisit[i][M - 1] = true;
			q.add(new Pos(0, i));
			q.add(new Pos(M - 1, i));
		}
		
		for (int i = 1; i < M - 1; i++) {
			isVisit[0][i] = true;
			isVisit[N - 1][i] = true;
			q.add(new Pos(i, 0));
			q.add(new Pos(i, N - 1));
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
					isVisit[ny][nx] = true;
					q.add(new Pos(nx, ny));
				} else {
					isVisit[ny][nx] = true;
					temp[ny][nx] = 0;
				}
			}
		}
		
		if (check(temp) == 0) {
			System.out.println(time);
			System.out.println(check(map));
		} else {
			map = temp;
			next();
		}
	}
	
	public static int check(int[][] checkMap) {	
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (checkMap[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		return cnt;
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