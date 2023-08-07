import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N * 2 - 1];
		
		calc(0, N - 1, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				if (arr[i][j] == 0) sb.append(" ");
				else sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void calc(int x, int y, int n) {
		if (n == 3) {
			for (int i = 0; i < 5; i++) {
				arr[y][x + i] = 1;
			}
			arr[y - 1][x + 1] = 1;
			arr[y - 1][x + 3] = 1;
			arr[y - 2][x + 2] = 1;
		} else {
			calc(x, y, n / 2);
			calc(x + n, y, n /2);
			calc(x + n / 2, y - n / 2, n /2);
		}
	}
}