import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Data {
	int T, P;

	public Data(int t, int p) {
		T = t;
		P = p;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Data[] arr = new Data[N];
		int[] dp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i <= N; i++) {
			if (i > 0) {
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}
			
			if (i < N && i + arr[i].T <= N) {
				dp[i + arr[i].T] = Math.max(dp[i + arr[i].T], dp[i] + arr[i].P);
			}
		}
		
		System.out.println(dp[N]);
	}
}