import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y, d;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getD() {
		return d;
	}

	public Pos(int y, int x) {
		this.x = x;
		this.y = y;
	}

	public Pos(int y, int x, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken()); // 맵의 크기
		int M = Integer.parseInt(st1.nextToken()); // 태울 승객
		int F = Integer.parseInt(st1.nextToken()); // 연료
		int[][] map = new int[N][N];
		Pos[][] people = new Pos[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
		
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		Pos taxi = new Pos(Integer.parseInt(st3.nextToken()) - 1, Integer.parseInt(st3.nextToken()) - 1);
	
		for (int i = 0; i < M; i++) {
			StringTokenizer st4 = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st4.nextToken()) - 1;
			int x1 = Integer.parseInt(st4.nextToken()) - 1;
			int y2 = Integer.parseInt(st4.nextToken()) - 1;
			int x2 = Integer.parseInt(st4.nextToken()) - 1;
			
			people[y1][x1] = new Pos(y2, x2);
		}
		
		boolean isChange = true;
		
		while (isChange) {
			isChange = false;
			
			PriorityQueue<Pos> pq = new PriorityQueue<>(Comparator.comparing(Pos::getD).thenComparing(Pos::getY).thenComparing(Pos::getX));
			boolean[][] isVisit = new boolean[N][N];
			pq.add(taxi);
			isVisit[taxi.y][taxi.x] = true;
			int min = Integer.MAX_VALUE;
			
			while (!pq.isEmpty()) {
				Pos c = pq.poll();
				
				if (people[c.y][c.x] != null) {
					Pos e = people[c.y][c.x];
					people[c.y][c.x] = null;
					isChange = true;
					
					F -= c.d;
					if (F < 0) {
						System.out.println(-1);
						return;
					} else {
						int r = bfs(new Pos (c.y, c.x , 0), e, map);
						
						if (r == -1) {
							System.out.println(-1);
							return;
						}
						
						F -= r;
						
						if (F < 0) {
							System.out.println(-1);
							return;
						} else {
							isChange = true;
							taxi = new Pos(e.y, e.x, 0);
							F += r * 2;
							break;
						}
					}
				}
				
				for (int d = 0; d < 4; d++) {
					int nx = c.x + dx[d];
					int ny = c.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					
					if (map[ny][nx] == 1) {
						continue;
					}
					
					if (!isVisit[ny][nx] && c.d + 1 <= min) {
						if (people[ny][nx] != null) {
							min = c.d + 1;
						}
						pq.add(new Pos(ny, nx, c.d + 1));
						isVisit[ny][nx] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j< N; j++) {
				if (people[i][j] != null) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(F);
	}
	
	public static int bfs(Pos p1, Pos p2, int[][] map) {
		boolean[][] isVisit = new boolean[N][N];
		Queue<Pos> q = new LinkedList<>();
		q.offer(p1);
		isVisit[p1.y][p1.x] = true;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			if (c.y == p2.y && c.x == p2.x) {
				return c.d;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				
				if (map[ny][nx] == 1) {
					continue;
				}
				
				if (!isVisit[ny][nx]) {
					q.add(new Pos(ny, nx, c.d + 1));
					isVisit[ny][nx] = true;
				}
			}
		}
		
		return -1;
	}
}