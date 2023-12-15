import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int diff = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = 0;
		
		while (s < N && e < N) {
			if (arr[e] - arr[s] >= M) {
				diff = Math.min(diff, arr[e] - arr[s]);
				s++;
			} else {
				e++;
			}
		}
		
		System.out.println(diff);
	}
}