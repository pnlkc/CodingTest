import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = { 2, 3, 5, 7, 11 };
			int[] result = new int[5];

			for (int i = 0; i < 5; i++) {
				while (N % arr[i] == 0) {
					result[i]++;
					N /= arr[i];
				}
			}

			System.out.println(String.format("#%d %s", tc, Arrays.stream(result)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" "))));
		}
	}
}