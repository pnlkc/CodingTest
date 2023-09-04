import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B, min;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			B = Integer.parseInt(st1.nextToken());
			arr = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
			}

			calc(0, 0);

			System.out.println("#" + tc + " " + (min - B));
		}
	}

	public static void calc(int idx, int sum) {
		if (min <= sum)
			return;
		
		if (B <= sum)
			min = Math.min(min, sum);

		if (idx == N)
			return;

		calc(idx + 1, sum);
		calc(idx + 1, sum + arr[idx]);
	}
}