import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		long[] presum = new long[1000001];
		
		init(arr, presum);
		
		for (; T > 0; T--) {
			int N = Integer.parseInt(br.readLine());
			sb.append(presum[N] + "\n");
		}
		
		System.out.print(sb);
	}
	
	public static void init(int[] arr, long[] presum) {
		for (int i = 1; i <= 1000000; i++) {
			int num = 1;
			
			while (num * i <= 1000000) {
				arr[i * num] += i;
				num++;
			}
		}
		
		for (int i = 1; i <= 1000000; i++) {
			presum[i] += presum[i - 1] + arr[i];
		}
	}
}