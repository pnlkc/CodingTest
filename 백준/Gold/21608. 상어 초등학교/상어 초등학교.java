import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 0;
	static int[][] map, info;
	static int[] score = { 0, 1, 10, 100, 1000 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int satisfaction = 0;

	// 초기 입력 값을 세팅하는 메소드
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		info = new int[N * N + 1][4];
		
		for (int i = 1; i <= N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int current = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 4; j++) {
				int like = Integer.parseInt(st.nextToken());
				info[current][j] = like;
			}

			setPlace(current);
			
		}
	}
	
	// 학생의 위치를 결정하는 메소드
	public static void setPlace(int num) {
		int[][][] result = new int[N][N][2]; 
		int maxLike = 0;
		int maxEmpty = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) { // 비어있는 칸이 아닌 경우
					continue;
				}
				
				int likeCnt = 0;
				int emptyCnt = 0;
				
				for (int d = 0; d < 4; d++) {
					int nx = j + dx[d];
					int ny = i + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					
					if (contains(map[ny][nx], info[num])) {
						likeCnt++;
					} else if (map[ny][nx] == 0) {
						emptyCnt++;
					}
				}
				
				result[i][j][0] = likeCnt;
				result[i][j][1] = emptyCnt;

				if (maxLike < likeCnt) { // 이전에 좋아하는 학생이 인접한 칸에 가장 많은 칸보다 더 많은 경우
					maxLike = likeCnt;
					maxEmpty = emptyCnt;
				} else if (maxLike == likeCnt) { // 이전에 좋아하는 학생이 인접한 칸에 가장 많은 칸과 같은 경우
					if (maxEmpty < emptyCnt) { // 인접한 칸 중에서 비어있는 칸이 이전보다 더 많은 경우
						maxEmpty = emptyCnt;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) { // 비어있는 칸이 아닌 경우
					continue;
				}
				
				if (result[i][j][0] == maxLike && result[i][j][1] == maxEmpty) { // 최적의 칸인 경우
					map[i][j] = num;
					return; // 문제의 3번 조건 (1, 2 조건이 여러개인 경우 행 -> 열 최솟값으로 배치)
				}
			}
		}
	}
	
	// 좋아하는 친구 포함여부를 확인하는 메소드
	public static boolean contains(int num, int[] arr) {
		for (int i = 0; i < 4; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		
		return false;
	}
	
	// 만족도 총합을 계산하는 메소드
	public static void calcSatisfaction() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = map[i][j];
				int cnt = 0;
				
				for (int d = 0; d < 4; d++) {
					int nx = j + dx[d];
					int ny = i + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					
					if (contains(map[ny][nx], info[num])) {
						cnt++;
					}
				}
				
				satisfaction += score[cnt];
			}
		}
		
		System.out.println(satisfaction);
	}

	public static void main(String[] args) throws IOException {
		init();
		calcSatisfaction();
	}
}