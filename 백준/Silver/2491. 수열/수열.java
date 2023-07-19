import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp1 = new int[n];
		dp1[0] = 1;
		int[] arr = new int[n];
		int max = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n; i++) {
			if (arr[i] >= arr[i - 1]) {
				dp1[i] = dp1[i - 1] + 1;
			} else {
				dp1[i] = 1;
			}
			max = Math.max(dp1[i], max);
		}
		
		int[] dp2 = new int[n];
		dp2[0] = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] <= arr[i - 1]) {
				dp2[i] = dp2[i - 1] + 1;
			} else {
				dp2[i] = 1;
			}
			max = Math.max(dp2[i], max);
		}
		
		System.out.println(max);
	}
}