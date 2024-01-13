import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R, X;
	static int r = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		calc(arr, 1, 0, 0);
		calc(arr, 1, arr[0], arr[0]);
		
		System.out.println(r);
	}
	
	public static void calc(int[] arr, int idx, int sum, int min) {
		if (idx >=  N) {
			return;
		}
		
		int newSum = sum + arr[idx];
		
		if (newSum <= R) {
			if (min == 0) {
				calc(arr, idx + 1, newSum, arr[idx]);
			} else {
				if (newSum >= L && arr[idx] - min >= X) {
					r++;
				}
				
				calc(arr, idx + 1, newSum, min);
			}
		}
		
		calc(arr, idx + 1, sum, min);
	}
}