import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] presum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			presum[i] = presum[i - 1] + arr[i - 1];
		}

		for (int i = 1; i < N - 1; i++) {
			r = Math.max(r, presum[N] - presum[1] + presum[N] - presum[i + 1] - arr[i]);
			r = Math.max(r, presum[N] - presum[0] + presum[i + 1] - presum[0] - arr[N - 1] - arr[i] * 2);
			r = Math.max(r, presum[N] - presum[i] + presum[i + 1] - presum[1] - arr[N - 1]);
		}

		System.out.println(r);
	}
}