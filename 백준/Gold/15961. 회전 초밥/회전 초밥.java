import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + k];
		int[] cnt = new int[d + 1];
		int max = 0;
		int result = 1;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = N; i < N + k; i++) {
			arr[i] = arr[i - N];
		}
		
		cnt[c]++;
		
		for (int i = 0; i < k; i++) {
			if (++cnt[arr[i]] == 1) {
				result++;
			}
		}
		
		max = result;
		
		for (int i = k; i < N + k; i++) {
			if (--cnt[arr[i - k]] == 0) {
				result--;
			}
			
			if (++cnt[arr[i]] == 1) {
				result++;
			}
			
			max = Math.max(max, result);
		}
		
		System.out.println(max);
	}
}