import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Data {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;

	public Data(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) { // 자를 위치
			Data data = new Data(arr[i], arr[i]);
			
			for (int j = i; j >= 0; j--) { // 시작 위치
				data.min = Math.min(data.min, arr[j]);
				data.max = Math.max(data.max, arr[j]);
				
				dp[i + 1] = Math.max(dp[i + 1], dp[j] + data.max - data.min);
			}
		}
		
		System.out.println(dp[N]);
	}
}