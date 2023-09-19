import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int L = Integer.parseInt(st1.nextToken());
		int[][] map = new int[N][N];
		boolean[][] rBuild = new boolean[N][N];
		boolean[][] cBuild = new boolean[N][N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			// 가로 방향
			int rCnt = 0;
			int rh = map[i][0];
			boolean r = false;
			boolean rCan = true;

			for (int j = 0; j < N; j++) {
				if (r) {
					if (map[i][j] == rh) {
						rBuild[i][j] = true;
						if (++rCnt == L) {
							r = false;
							rCnt = 0;
						}
					} else {
						rCan = false;
						break;
					}
				} else {
					if (Math.abs(map[i][j] - rh) > 1) {
						rCan = false;
						break;
					} else if (map[i][j] - rh == -1) {
						rBuild[i][j] = true;
						rh = map[i][j];

						if (++rCnt == L) {
							r = false;
							rCnt = 0;
						} else {
							r = true;
							rCnt = 1;
						}
					} else if (map[i][j] - rh == 1) {
						for (int k = 1; k <= L; k++) {
							if (j - k < 0 || map[i][j - k] != rh || rBuild[i][j - k]) {
								rCan = false;
								break;
							}
							
							rBuild[i][j - k] = true;
						}
						
						rh = map[i][j];
					}
				}

			}

			if (rCnt != 0) {
				rCan = false;
			}

			if (rCan) {
				cnt++;
			}

			// 세로 방향
			int cCnt = 0;
			int ch = map[0][i];
			boolean c = false;
			boolean cCan = true;

			for (int j = 0; j < N; j++) {
				if (c) {
					if (map[j][i] == ch) {
						cBuild[j][i] = true;
						
						if (++cCnt == L) {
							c = false;
							cCnt = 0;
						}
					} else {
						cCan = false;
						break;
					}
				} else {
					if (Math.abs(map[j][i] - ch) > 1) {
						cCan = false;
						break;
					} else if (map[j][i] - ch == -1) {
						cBuild[j][i] = true;
						ch = map[j][i];
						
						if (++cCnt == L) {
							c = false;
							cCnt = 0;
						} else {
							c = true;
							cCnt = 1;
						}
					} else if (map[j][i] - ch == 1) {
						for (int k = 1; k <= L; k++) {
							if (j - k < 0 || map[j - k][i] != ch || cBuild[j - k][i]) {
								cCan = false;
								break;
							}
							
							cBuild[j - k][i] = true;
						}
						
						ch = map[j][i];
					}

				}

			}

			if (cCnt != 0) {
				cCan = false;
			}

			if (cCan) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}