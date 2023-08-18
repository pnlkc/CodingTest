import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new char[N][2 * N - 1]; // 배열을 만들어서 관리하겠다.
		m(N, 0, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				if (arr[i][j] == '*') sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void m(int N, int r, int c) { // N:크기, r:시작 행, c:시작 열
		if (N == 3) {
			arr[r][c + 2] = '*';
			arr[r + 1][c + 1] = '*';
			arr[r + 1][c + 3] = '*';
			for (int i = 0; i < 5; i++) {
				arr[r + 2][c + i] = '*';
			}
		} else {
			m(N / 2, r, c + N / 2);
			m(N / 2, r + N / 2, c);
			m(N / 2, r + N / 2, c + N);
		}
	}
}
