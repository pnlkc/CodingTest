import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			int result = Integer.MIN_VALUE;

			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}

			if (N > M) {
				int[] temp = arr1;
				arr1 = arr2;
				arr2 = temp;

				int tempNum = N;
				N = M;
				M = tempNum;
			}

			for (int i = 0; i <= M - N; i++) {
				int sum = 0;

				for (int j = 0; j < N; j++) {
					sum += arr1[j] * arr2[i + j];
				}

				result = Math.max(result, sum);
			}

			sb.append(result).append("\n");
		}

		System.out.print(sb);
	}
}