import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] mx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] my = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, 1, 1, -1 };
	static int[] dy = { -1, -1, 1, 1 };
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] cloud = new boolean[N][N];

		initCloud(cloud);
		initMap(map);
		
		for (int command = 0; command < M; command++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			boolean[][] newCloud = new boolean[N][N];
			
			moveCloud(cloud, newCloud, d, s);
			dropRain(map, newCloud);
			map = copyWater(map, newCloud);
			cloud = makeCloud(map, newCloud);
		}
		
		System.out.println(calc(map));
	}
	
	// 비바라기 시전
	public static void initCloud(boolean[][] cloud) {
		cloud[N - 1][0] = true;
		cloud[N - 1][1] = true;
		cloud[N - 2][0] = true;
		cloud[N - 2][1] = true;
	}
	
	// 바구니 초기화
	public static void initMap(int[][] map) throws IOException {
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	// 1번 과정
	public static void moveCloud(boolean[][] cloud, boolean[][] newCloud, int d, int s) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int nx = j + mx[d] * s;
				int ny = i + my[d] * s;
				
				while (nx < 0) {
					nx += N;
				}
				
				while (ny < 0) {
					ny += N;
				}
				
				nx %= N;
				ny %= N;
				
				newCloud[ny][nx] = cloud[i][j];
			}
		}
	}
	
	// 2번 과정
	public static void dropRain(int[][] map, boolean[][] cloud) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) map[i][j]++;
			}
		}
	}
	
	// 4번 과정
	public static int[][] copyWater(int[][] map, boolean[][] cloud) {
		int[][] newMap = new int[N][N];
		
		copyArr(map, newMap);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!cloud[i][j]) continue;
				
				for (int d = 0; d < 4; d++) {
					int nx = j + dx[d];
					int ny = i + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if (map[ny][nx] == 0) continue;
					
					newMap[i][j]++;
				}
			}
		}
		
		return newMap;
	}
	
	// 3번 과정 + 5번 과정
	public static boolean[][] makeCloud(int[][] map, boolean[][] hasCloud) {
		boolean[][] newCloud = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !hasCloud[i][j]) {
					map[i][j] -= 2;
					newCloud[i][j] = true;
				}
			}
		}
		
		return newCloud;
	}
	
	// 바구니에 들어있는 물의 양의 합 계산
	public static int calc(int[][] map) {
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += map[i][j];
			}
		}
		
		return result;
	}
	
	public static void copyArr(int[][] ori, int[][] dest) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dest[i][j] = ori[i][j];
			}
		}
	}
	
	public static void copyArr(boolean[][] ori, boolean[][] dest) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dest[i][j] = ori[i][j];
			}
		}
	}
}