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
			int K = sc.nextInt();
			String[] arr = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
			Integer[] score = new Integer[N];
			int num = 0;
			int pos = 0;
			int result = 0;

			for (int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();

				score[i] = a * 35 + b * 45 + c * 20;

				if (i == K - 1) {
					num = score[i];
				}
			}

			Arrays.sort(score, Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				if (score[i] == num) {
					pos = i;
					break;
				}
			}

			result = pos / (N / 10);

			System.out.println(String.format("#%d %s", tc, arr[result]));
		}
	}
}