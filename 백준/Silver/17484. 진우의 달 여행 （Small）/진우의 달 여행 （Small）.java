import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[][] dp = new int[3][M];

		for (int i = 0; i < N; i++) {
			int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			if (i == 0) {
				for (int j = 0; j < M; j++) {
					dp[0][j] = arr[j];
					dp[1][j] = arr[j];
					dp[2][j] = arr[j];
				}
			} else {
				int[][] newDp = new int[3][M];

				for (int j = 0; j < 3; j++) {
					Arrays.fill(newDp[j], 1000);
				}

				for (int j = 0; j < M; j++) {
					if (j + 1 < M)
						newDp[0][j] = Math.min(dp[1][j + 1], dp[2][j + 1]) + arr[j];
					
					newDp[1][j] = Math.min(dp[0][j], dp[2][j]) + arr[j];
					
					if (j - 1 >= 0)
						newDp[2][j] = Math.min(dp[0][j - 1], dp[1][j - 1]) + arr[j];
				}

				dp = newDp;
			}
		}

		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < M; j++) {
				min = Math.min(min, dp[i][j]);
			}
		}
		
		System.out.println(min);
	}
}