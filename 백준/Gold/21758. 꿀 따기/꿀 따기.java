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
		
		for (int i = 0; i < N; i++) {
			if (i > 1) {
				for (int j = 1; j < i; j++) {
					r = Math.max(r, presum[i + 1] - presum[1] + presum[i + 1] - presum[j + 1] - arr[j]);
				}
			}
			
			r = Math.max(r, presum[i + 1] - presum[1] + presum[N] - presum[i] - arr[N - 1]);
			
			if (i < N - 2) {
				for (int j = i + 1; j < N - 1; j++) {
					r = Math.max(r, presum[N] - presum[i] - arr[N - 1] + presum[j + 1] - presum[i] - arr[j] * 2);
				}
			}
		}
		
		System.out.println(r);
	}
}
