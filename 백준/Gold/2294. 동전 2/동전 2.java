import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] <= k)
				dp[arr[i]] = 1;
		}

		arr = Arrays.stream(arr).distinct().toArray();
		Arrays.sort(arr);

		if (arr[0] > k) {
			System.out.println(-1);
			return;
		}

		for (int i = arr[0]; i <= k; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > i)
					break;

				if (i == arr[j] || dp[i - arr[j]] != 0) {
					if (dp[i] == 0) {
						dp[i] = dp[i - arr[j]] + 1;
					} else {
						dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
					}
				}
			}
		}

		if (dp[k] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}