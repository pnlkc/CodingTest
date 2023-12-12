import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Data>[][] map = setMap(N);
		int sum = 0;
		
		for (int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[r][c].add(new Data(r, c, m, s, d));
		}
		
		for (int i = 0; i < K; i++) {
			map = progress(map, N);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j].isEmpty()) {
					for (Data c : map[i][j]) {
						sum += c.m;
					}
				}
			}
		}
		
		System.out.println(sum);
	}
	
	public static List<Data>[][] setMap(int N) {
		List<Data>[][] map = new ArrayList[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<Data>();
			}
		}
		
		return map;
	}
	
	public static List<Data>[][] progress(List<Data>[][] map, int N) {
		List<Data>[][] temp = setMap(N);
	
		// 파이어볼 이동
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j].isEmpty()) {
					for (Data c : map[i][j]) {
						int nr = c.r + dy[c.d] * c.s;
						int nc = c.c + dx[c.d] * c.s;
						
						while (nr < 0) {
							nr += N;
						}
						
						while (nc < 0) {
							nc += N;
						}
						
						nr %= N;
						nc %= N;
						
						temp[nr][nc].add(new Data(nr, nc, c.m, c.s, c.d));
					}
				}
			}
		}
		
		// 파이어볼 이동이 모두 끝난 뒤 작업
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!temp[i][j].isEmpty()) {
					if (temp[i][j].size() > 1) { // 이동한 칸에 파이어볼이 2개 이상인 경우
						List<Data> tempList = new ArrayList<>();
						int sumM = 0;
						int sumS = 0;
						int[] cnt = { 0, 0 };
						
						for (Data c : temp[i][j]) {
							if (c.d % 2 == 0) {
								cnt[0]++;
							} else {
								cnt[1]++;
							}
							
							sumM += c.m;
							sumS += c.s;
						}
						
						sumM /= 5;
						sumS /= temp[i][j].size();
						
						if (sumM > 0) {
							if (cnt[0] == 0 || cnt[1] == 0) {
								tempList.add(new Data(i, j, sumM, sumS, 0));
								tempList.add(new Data(i, j, sumM, sumS, 2));
								tempList.add(new Data(i, j, sumM, sumS, 4));
								tempList.add(new Data(i, j, sumM, sumS, 6));
							} else {
								tempList.add(new Data(i, j, sumM, sumS, 1));
								tempList.add(new Data(i, j, sumM, sumS, 3));
								tempList.add(new Data(i, j, sumM, sumS, 5));
								tempList.add(new Data(i, j, sumM, sumS, 7));
							}
						}
						
						temp[i][j] = tempList;
					}
				}
			}
		}
		
		return temp;
	}
}

class Data {
	int r, c, m, s, d;

	public Data(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}