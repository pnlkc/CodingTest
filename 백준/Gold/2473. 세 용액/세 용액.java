import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long[] min = new long[] { Long.MAX_VALUE, 0L, 0L, 0L };
		
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 2; j < n; j++) {
				int s = i + 1;
				int e = j - 1;
				int mid = (s + e) / 2;
				
				while(s < e) {
					if (arr[i] + arr[j] + arr[mid] < 0) {
						s = mid + 1;
						if (Math.abs(arr[i] + arr[j] + arr[mid]) < min[0]) {
							min = new long[] {Math.abs(arr[i] + arr[j] + arr[mid]), arr[i], arr[mid], arr[j]};
						}
					} else if (arr[i] + arr[j] + arr[mid] > 0) {
						e = mid;
						if (Math.abs(arr[i] + arr[j] + arr[mid]) < min[0]) {
							min = new long[] {Math.abs(arr[i] + arr[j] + arr[mid]), arr[i], arr[mid], arr[j]};
						}
					} else {
						System.out.println(arr[i] + " " + arr[mid] + " " + arr[j]);
						return;
					}
					
					mid = (s + e) / 2;
				}
				
				if (Math.abs(arr[i] + arr[j] + arr[mid]) < min[0]) {
					min = new long[] {Math.abs(arr[i] + arr[j] + arr[mid]), arr[i], arr[mid], arr[j]};
				}
			}
		}
		
		System.out.println(min[1] + " " + min[2] + " " + min[3]);
	}
}