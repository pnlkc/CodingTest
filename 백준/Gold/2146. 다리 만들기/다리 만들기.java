import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y, d;

	public Pos(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 섬별 번호 지정
		boolean[][] isVisit = new boolean[N][N]; 
		int num = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisit[i][j] && map[i][j] == 1) {
					Queue<Pos> q = new LinkedList<>();
					q.offer(new Pos(j, i, 0));
					isVisit[i][j] = true;
					
					while (!q.isEmpty()) {
						Pos c = q.poll();
						map[c.y][c.x] = num;
						
						for (int d = 0; d < 4; d++) {
							int nx = c.x + dx[d];
							int ny = c.y + dy[d];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
								continue;
							}
							
							if (isVisit[ny][nx]) {
								continue;
							}
							
							if (map[ny][nx] != 1) {
								continue;
							}
							
							isVisit[ny][nx] = true;
							q.offer(new Pos(nx, ny, 0));
						}
					}
					
					num++;
				}
			}
		}
		
		// 섬별 다리 놓기
		List<Integer> island = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && !island.contains(map[i][j])) {
					island.add(map[i][j]);
					int[][] dist = new int[N][N];
					int cNum = map[i][j];
					
					for (int k = 0; k < N; k++) {
						Arrays.fill(dist[k], Integer.MAX_VALUE);
					}
					
					Queue<Pos> q = new LinkedList<>();
					q.offer(new Pos(j, i, 0));
					dist[i][j] = 0;
					
					while (!q.isEmpty()) {
						Pos c = q.poll();
						if (result <= c.d) continue;
						
						for (int d = 0; d < 4; d++) {
							int nx = c.x + dx[d];
							int ny = c.y + dy[d];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
								continue;
							}
							
							if (dist[ny][nx] == 0 || dist[ny][nx] < c.d) {
								continue;
							}
							
							if (map[ny][nx] == cNum) {
								dist[ny][nx] = 0;
								q.offer(new Pos(nx, ny, c.d));
							} else if (map[ny][nx] == 0) {
								if (dist[ny][nx] > c.d + 1) {
									dist[ny][nx] = c.d + 1;
									q.offer(new Pos(nx, ny, c.d + 1));
								}
							} else {
								result = Math.min(result, c.d);
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}