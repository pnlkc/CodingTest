import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long result = 0L;
			int prevMax = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (prevMax > arr[i]) {
					result += prevMax - arr[i];
				} else {
					prevMax = arr[i];
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}