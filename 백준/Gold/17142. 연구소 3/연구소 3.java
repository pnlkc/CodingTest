import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int result; // 최소 시간을 담을 변수
	static int maxCnt; // 0의 개수를 담을 변수 (bfs시 모든 빈칸에 바이러스를 퍼트렸는지 확인용)
	static int[] pick;
	static int[][] map;
	static List<Pos> vList = new ArrayList<>(); // 비활성 바이러스 리스트
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		map = new int[N][N];
		pick = new int[M];
		result = -1;

		// 지도 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());

				if (map[i][j] == 2) { // 비활성 바이러스인 경우
					vList.add(new Pos(i, j)); // 비활성 바이러스 리스트에 추가
				} else if (map[i][j] == 0) { // 빈 칸인 경우
					maxCnt++; // 빈 칸 개수 추가
				}
			}
		}

		pick(0, 0);

		System.out.println(result);
	}

	// 활성화 시킬 바이러스  선택하는 메소드
	public static void pick(int idx, int cnt) {
		if (cnt == M) { // M개 만큼 고른 경우
			int r = bfs(pick); // bfs 돌린 결과

			// bfs 돌린 결과 연구소의 모든 빈칸이 감염이 되었을 경우 최솟값 갱신
			if (r != -1 && result == -1) { // 이전에 가능한 경우가 없었던 경우
				result = r;
			} else if (r != -1 && result != -1) { // 이전에 가능한 경우가 있었던 경우
				result = Math.min(result, r);
			}

			return;
		}

		if (idx >= vList.size()) { // M개를 선택하지 못한 경우 
			return;
		}

		pick[cnt] = idx; // cnt번에 idx를 선택
		pick(idx + 1, cnt + 1); // 현재 idx 선택한 경우
		pick(idx + 1, cnt); // 현재 idx 선택하지 않은 경우
	}

	// bfs 수행 메소드
	public static int bfs(int[] sArr) {
		int cnt = 0; // 연구소의 빈칸 감염 개수
		int r = 0; // 진행 시간을 담을 변수
		Queue<Pos> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[N][N];

		// 시작 위치를 모두 큐에 추가 및 방문 처리
		for (int i : sArr) {
			Pos c = vList.get(i);
			q.add(c);
			isVisit[c.y][c.x] = true;
		}

		while (!q.isEmpty()) {
			Pos c = q.poll();
			if (map[c.y][c.x] == 0) { // 빈 칸인 경우 진행 시간 갱신
				r = Math.max(r, c.d);
			}
			
			if (result != -1 && r >= result) { // 진행 상황이 최솟값보다 크면 탐색 중지
				return -1;
			}

			// 4방 탐색
			for (int d = 0; d < 4; d++) { 
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) { // 범위를 벗어난 경우
					continue;
				}

				if (map[ny][nx] == 1) { // 벽인 경우
					continue;
				}

				if (isVisit[ny][nx]) { // 이미 방문한 경우
					continue;
				}

				if (map[ny][nx] == 0) { // 빈 칸인 경우
					cnt++; // cnt 추가
				}
				
				isVisit[ny][nx] = true;
				q.add(new Pos(ny, nx, c.d + 1));
			}
		}

		if (cnt == maxCnt) { // 연구소의 모든 빈칸이 감염된 경우
			return r;
		} else { // 연구소의 모든 빈칸이 감염되지 않은 경우
			return -1;
		}
	}
}

class Pos {
	int x, y, d;

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
