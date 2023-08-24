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
		int[][] map = new int[N][N]; // 도로 상황
		Pos[][] people = new Pos[N][N]; // 승객 위치
		
		// 도로 상황 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
		
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		// 택시 초기 위치 입력
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		Pos taxi = new Pos(Integer.parseInt(st3.nextToken()) - 1, Integer.parseInt(st3.nextToken()) - 1);
		
		// 승객 위치 입력
		for (int i = 0; i < M; i++) {
			StringTokenizer st4 = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st4.nextToken()) - 1;
			int x1 = Integer.parseInt(st4.nextToken()) - 1;
			int y2 = Integer.parseInt(st4.nextToken()) - 1;
			int x2 = Integer.parseInt(st4.nextToken()) - 1;
			
			people[y1][x1] = new Pos(y2, x2);
		}
		
		boolean isChange = true; // 승객을 태웠는지 못 태웠는지 확인
		
		while (isChange) { // 승객을 태운 경우에만 계속 진행
			isChange = false; // 일단 승객을 못 태운 것으로 변경
			
			// 우선순위큐를 거리 -> y좌표 값 -> x좌표 값 순으로 정렬
			PriorityQueue<Pos> pq = new PriorityQueue<>(Comparator.comparing(Pos::getD).thenComparing(Pos::getY).thenComparing(Pos::getX));
			boolean[][] isVisit = new boolean[N][N];
			pq.add(taxi);
			isVisit[taxi.y][taxi.x] = true;
			int min = Integer.MAX_VALUE;
			
			while (!pq.isEmpty()) { // 가장 가까운 승객 찾기 bfs 변형
				Pos c = pq.poll();
				
				if (people[c.y][c.x] != null) { // 가장 가까운 승객을 찾은 경우
					Pos e = people[c.y][c.x]; // 승객을 위치에서 제거하기 전에 목적지 저장 
					people[c.y][c.x] = null; // 승객을 위치에서 제거
					isChange = true; // 승객을 태웠으므로 계속 진행하도록 변경
					
					F -= c.d; // 승객을 태우러 가는데 사용한 연료 차감
					if (F < 0) { // 승객을 태우러 가는 중 연료가 떨어진 경우
						System.out.println(-1);
						return;
					} else { // 승객을 태우러 갈 연료가 충분한 경우
						int r = bfs(new Pos (c.y, c.x , 0), e, map); // 출발지에서 목적지까지의 거리
						
						if (r == -1) { // 목적지까지 도달할 수 없는 경우
							System.out.println(-1);
							return;
						}
						
						F -= r; // 목적지까지 가는데 필요한 연료 차감
						
						if (F < 0) { // 목적지까지 가는 중 연료가 떨어진 경우
							System.out.println(-1);
							return;
						} else { // 목적지까지 갈 연료가 충분한 경우
							taxi = new Pos(e.y, e.x, 0);
							F += r * 2;
							break;
						}
					}
				}
				
				for (int d = 0; d < 4; d++) { // 4방 탐색
					int nx = c.x + dx[d];
					int ny = c.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					
					if (map[ny][nx] == 1) {
						continue;
					}
					
					if (!isVisit[ny][nx] && c.d + 1 <= min) {
						if (people[ny][nx] != null) { // 승객을 찾으면 최소거리 갱신, 같은 거리의 모든 승객을 찾기 위해서 필요
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
	
	// 승객의 출발지에서 목적지 사이의 최소거리를 구하기 위한 bfs
	public static int bfs(Pos p1, Pos p2, int[][] map) {
		boolean[][] isVisit = new boolean[N][N];
		Queue<Pos> q = new LinkedList<>();
		q.offer(p1);
		isVisit[p1.y][p1.x] = true;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			if (c.y == p2.y && c.x == p2.x) { // 목적지에 도착한 경우
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
		
		return -1; // 승객이 목적지에 도착할 수 없는 경우
	}
}