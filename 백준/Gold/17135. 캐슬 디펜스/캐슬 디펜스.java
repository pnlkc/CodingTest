import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int d;
	static int[][] map; // 지도 전역 변수
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		d = Integer.parseInt(st1.nextToken());

		// 지도 생성
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		combination();

		System.out.println(max);
	}

	// 궁수 3명 배치 조합
	public static void combination() {
		for (int a1 = 0; a1 < m - 2; a1++) {
			for (int a2 = a1 + 1; a2 < m - 1; a2++) {
				for (int a3 = a2 + 1; a3 < m; a3++) {
					game(a1, a2, a3);
				}
			}
		}
	}

	public static void game(int a1, int a2, int a3) {
		int[][] nMap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new); // 지도 깊은 복사
		int newN = n;
		int cnt = 0; // 적 잡은 수
		int[] al = { a1, a2, a3 }; // 궁수 리스트

		// 게임 진행
		while (newN >= 0) {
			ArrayList<Integer> xl = new ArrayList<>();
			ArrayList<Integer> yl = new ArrayList<>();
			boolean[] isShot = new boolean[3]; // 궁수 발사 여부 리스트
			// 궁수들이 화살 발사
			for (int k = 0; k < 3; k++) {
				if (isShot[k]) continue; // 해당 궁수가 발사했으면 continue
				int minDist = Integer.MAX_VALUE;
				int x = Integer.MAX_VALUE;
				int y = -1;
				
				for (int i = newN - 1; i >= Math.max(newN - d, 0); i--) {
					for (int j = 0; j < m; j++) {
						int dist = newN - i + Math.abs(al[k] - j);
						// d를 벗어나는 적인지 검사
						if (dist <= minDist && dist <= d) {
							if (nMap[i][j] == 1) {
								if (dist == minDist && x <= j) continue;
								x = j;
								y = i;
								minDist = dist;
							}
						}
					}
				}
				
				if (x != Integer.MAX_VALUE && y != -1) {
					xl.add(x);
					yl.add(y);
					isShot[k] = true;
				}
			}

			for (int i = 0; i < yl.size(); i++) {
				if (nMap[yl.get(i)][xl.get(i)] == 1) {
					nMap[yl.get(i)][xl.get(i)] = 0;
					cnt++;
				}
			}

			newN--; // 적들 1칸 전진
		}

		max = Math.max(max, cnt);
	}
}