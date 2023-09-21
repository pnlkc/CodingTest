import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, result;
	static boolean[][] connect;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		H = Integer.parseInt(st1.nextToken());
		connect = new boolean[H][N];
		result = 4;

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());

			connect[a - 1][b - 1] = true;
		}

		if (play()) {
			System.out.println(0);
		} else {
			add(0);
			System.out.println((result >= 4) ? -1 : result);
		}
	}

	// 사다리 추가하는 함수
	public static void add(int cnt) {
		if (cnt >= result)
			return;
		if (cnt == 3)
			return;

		for (int h = 0; h < H; h++) {
			for (int x = 0; x < N - 1; x++) {
				if (canAdd(x, h)) {
					connect[h][x] = true;
					if (play()) {
						result = cnt + 1;
					} else {
						add(cnt + 1);
					}
					connect[h][x] = false;
				}
			}
		}
	}

	// 사다리 추가 가능한지 판별하는 함수
	public static boolean canAdd(int x, int h) {
		if (connect[h][x]) {
			return false;
		}
		
		if (x - 1 >= 0) {
			if (connect[h][x - 1]) {
				return false;
			}
		}

		if (x + 1 < N) {
			if (connect[h][x + 1]) {
				return false;
			}
		}

		return true;
	}
	
	// 사다리 게임 진행하는 함수
	public static boolean play() {
		for (int i = 0; i < N; i++) {
			int x = i;
			int y = 0;

			while (y < H) {
				if (connect[y][x]) {
					x++;
				} else if (x - 1 >= 0 && connect[y][x - 1]) {
					x--;
				}
				y++;
			}

			if (x != i) {
				return false;
			}
		}

		return true;
	}
}