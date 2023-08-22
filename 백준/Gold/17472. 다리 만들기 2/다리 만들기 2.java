import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Dist implements Comparable<Dist> {
	int a, b, d;

	public Dist(int a, int b, int d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}

	@Override
	public int compareTo(Dist o) {
		return d - o.d;
	}
}

public class Main {
	static int N, M;
	static int num = 1;
	static int[][] map;
	static boolean[][] isVisit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] parent, rank;
	static int v, r; // v = 간선의 개수, r = 최소 가중치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		map = new int[N][M];
		isVisit = new boolean[N][M];
		PriorityQueue<Dist> pq = new PriorityQueue<>();
		
		// 입력값 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		// 섬마다 번호 나누기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !isVisit[i][j]) {
					bfs(j, i);
				}
			}
		}
		
		// 그래프 생성
		for (int n = 1; n < num; n++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == n) {
						for (int d = 0; d < 4; d++) {
							int dist = 1;
							int nx = j + dist * dx[d];
							int ny = i + dist * dy[d];
							
							while (nx >= 0 && ny >= 0 && nx < M && ny < N) {
								if (map[ny][nx] != 0) break;
								dist++;
								nx = j + dist * dx[d];
								ny = i + dist * dy[d];
							}
							
							if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
								continue;
							}

							
							if (map[ny][nx] == 0 || map[ny][nx] == n) {
								continue;
							}
							
							if (dist < 3) {
								continue;
							}
							
							pq.offer(new Dist(n, map[ny][nx], dist - 1));
						}
					}
				}
			}
		}
		
		// 유니온 파인드
		parent = new int[num];
		rank = new int[num];
		
		for (int i = 0; i < num; i++) {
			parent[i] = i;
		}
		
		// 크루스칼
		while (!pq.isEmpty()) {
			Dist c = pq.poll();
			union(c.a, c.b, c.d);
			if (v == num - 2) break;
		}

		System.out.println(v != num - 2 || r == 0 ? -1 : r);
	}
	
	// 섬마다 번호 나누는 bfs
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		isVisit[y][x] = true;
		map[y][x] = num;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if (isVisit[ny][nx]) continue;
				if (map[ny][nx] == 0) continue;
				
				q.offer(new Pos(nx, ny));
				isVisit[ny][nx] = true;
				map[ny][nx] = num;
			}
		}
		
		num++;
	}
	
	// 유니온
	public static boolean union(int n1, int n2, int d) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if (p1 == p2) {
			return false;
		}
		
		if (rank[p1] > rank[p2]) {
			parent[p2] = p1;
		} else if (rank[p1] < rank[p2]) {
			parent[p1] = p2;
		} else {
			parent[p2] = p1;
			rank[p1]++;
		}
		
		v++;
		r += d;
		
		return true;
	}
	
	// 파인드
	public static int find(int n) {
		if (parent[n] != n) {
			return find(parent[n]);
		}
		return parent[n];
	}
}