import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Data {
	int minNum, cMax;

	public Data(int minNum, int cMax) {
		this.minNum = minNum;
		this.cMax = cMax;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Data[] dp = new Data[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = new Data(arr[0], 0);

		for (int i = 0; i < N; i++) {
			dp[i + 1] = new Data(Math.min(dp[i].minNum, arr[i]), Math.max(dp[i].cMax, arr[i] - dp[i].minNum));
			sb.append(dp[i + 1].cMax + " "); 
		}
		
		System.out.println(sb.toString().trim());
	}
}