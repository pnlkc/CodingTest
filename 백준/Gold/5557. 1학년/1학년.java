import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[21];
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (i == 0) {
				arr[num]++;
			} else if (i == N - 1) {
				System.out.println(arr[num]);
			} else {
				long[] newArr = new long[21];
				
				for (int j = 0; j <= 20; j++) {
					if (arr[j] != 0) {
						if (j + num >= 0 && j + num <= 20) {
							newArr[j + num] += arr[j];
						}
						
						if (j - num >= 0 && j - num <= 20) {
							newArr[j - num] += arr[j];
						}
					}
				}
				
				arr = newArr;
			}
		}
	}
}