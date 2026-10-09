import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();

			int A = P * W;
			int B = 0;

			if (W <= R) {
				B = Q;
			} else {
				B = Q + (W - R) * S;
			}

			System.out.println(String.format("#%d %d", tc, Math.min(A, B)));
		}
	}
}