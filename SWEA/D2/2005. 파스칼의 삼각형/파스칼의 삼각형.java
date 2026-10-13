import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
				}
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#" + tc + "\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append(arr[i][j]);

					if (j != i) {
						sb.append(" ");
					}
				}

				if (i != N - 1) {
					sb.append("\n");
				}
			}

			System.out.println(sb);
		}
	}
}