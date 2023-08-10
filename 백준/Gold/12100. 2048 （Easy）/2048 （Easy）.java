import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(0, 0, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));
		move(1, 0, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));
		move(2, 0, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));
		move(3, 0, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));

		System.out.println(result);
	}

	// dir => 0 : 상 / 1 : 우 / 2 : 하 / 3 : 좌
	public static void move(int dir, int depth, int[][] arr) {
		boolean[][] isChange = new boolean[N][N];

		if (dir == 0) { // 상
			for (int j = 0; j < N; j++) {
				for (int i = 1; i < N; i++) {
					if (arr[i][j] == 0)
						continue;

					int idx = i - 1;
					while (idx >= 0 && arr[idx][j] == 0) {
						idx--;
					}

					if (idx >= 0 && arr[idx][j] == arr[i][j] && !isChange[idx][j]) {
						arr[idx][j] *= 2;
						isChange[idx][j] = true;
						arr[i][j] = 0;
					} else {
						arr[idx + 1][j] = arr[i][j];
						if (idx + 1 != i) arr[i][j] = 0;
					}
				}
			}
		} else if (dir == 1) { // 우
			for (int i = 0; i < N; i++) {
				for (int j = N - 2; j >= 0; j--) {
					if (arr[i][j] == 0)
						continue;
					
					int idx = j + 1;
					while (idx < N && arr[i][idx] == 0) {
						idx++;
					}
					
					if (idx < N && arr[i][idx] == arr[i][j] && !isChange[i][idx]) {
						arr[i][idx] *= 2;
						isChange[i][idx] = true;
						arr[i][j] = 0;
					} else {
						arr[i][idx - 1] = arr[i][j];
						if (idx - 1 != j) arr[i][j] = 0;
					}
				}
			}
		} else if (dir == 2) { // 하
			for (int j = 0; j < N; j++) {
				for (int i = N - 2; i >= 0; i--) {
					if (arr[i][j] == 0)
						continue;

					int idx = i + 1;
					while (idx < N && arr[idx][j] == 0) {
						idx++;
					}

					if (idx < N && arr[idx][j] == arr[i][j] && !isChange[idx][j]) {
						arr[idx][j] *= 2;
						isChange[idx][j] = true;
						arr[i][j] = 0;
					} else {
						arr[idx - 1][j] = arr[i][j];
						if (idx - 1 != i) arr[i][j] = 0;
					}
				}
			}
		} else { // 좌
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (arr[i][j] == 0)
						continue;
					
					int idx = j - 1;
					while (idx >= 0 && arr[i][idx] == 0) {
						idx--;
					}
					
					if (idx >= 0 && arr[i][idx] == arr[i][j] && !isChange[i][idx]) {
						arr[i][idx] *= 2;
						isChange[i][idx] = true;
						arr[i][j] = 0;
					} else {
						arr[i][idx + 1] = arr[i][j];
						if (idx + 1 != j) arr[i][j] = 0;
					}
				}
			}
		}

		result = Math.max(result, check(arr));

		if (depth < 4) {
			move(0, depth + 1, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));
			move(1, depth + 1, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));
			move(2, depth + 1, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));
			move(3, depth + 1, Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new));
		}
	}

	public static int check(int[][] arr) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		return max;
	}
}