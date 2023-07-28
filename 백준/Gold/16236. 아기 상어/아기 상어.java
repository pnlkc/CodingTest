import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BabyShark {
	int x, y, z;

	public BabyShark(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}

class Fish extends BabyShark {
	public Fish(int x, int y, int z) {
		super(x, y, z);
	}
}

public class Main {
	static int[][] map;
	static boolean[][] isVisit;
	static int n;
	static BabyShark bs;
	static int time = 0;
	static int eat = 0;
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					bs = new BabyShark(j, i, 2);
					map[i][j] = 0;
				}
			}
		}

		bfs();
		System.out.println(time);
	}

	public static void bfs() {
		isVisit = new boolean[n][n]; // isVisit 초기화
		Comparator<Fish> comparator = Comparator.comparing(Fish::getZ).thenComparing(Fish::getY)
				.thenComparing(Fish::getX); // 거리, y좌표, x좌표 순으로 검색
		PriorityQueue<Fish> pq = new PriorityQueue<>(comparator);
		pq.add(new Fish(bs.x, bs.y, 0));
		isVisit[bs.y][bs.x] = true;

		while (!pq.isEmpty()) {
			Fish c = pq.poll();

			// 최단거리로 물고기를 먹을 수 있는 경우
			if (map[c.y][c.x] != 0 && map[c.y][c.x] < bs.z) {
				time += c.z; // 시간 추가
				if (++eat == bs.z) { // 아기 상어 몸 크기 변화 체크
					bs.z++;
					eat = 0;
				}
				map[c.y][c.x] = 0; // 물고기 먹은 자리 초기화
				bs = new BabyShark(c.x, c.y, bs.z); // 아기 상어 위치 업데이트
				bfs(); // bfs 반복
				break;
			}

			// bfs 알고리즘
			for (int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || isVisit[ny][nx])
					continue;
				if (map[ny][nx] > bs.z)
					continue;

				pq.add(new Fish(nx, ny, c.z + 1));
				isVisit[ny][nx] = true;
			}
		}
	}
}