import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int pos = 0;
			int speed = 0;

			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();

				if (command == 1) {
					speed += sc.nextInt();
				} else if (command == 2) {
					speed -= sc.nextInt();

					if (speed < 0) {
						speed = 0;
					}
				}

				pos += speed;
			}

			System.out.println(String.format("#%d %d", tc, pos));
		}
	}
}