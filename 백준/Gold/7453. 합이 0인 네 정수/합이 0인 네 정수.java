import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[4][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		int[] lArr = calc(arr[0], arr[1]);
		int[] rArr = calc(arr[2], arr[3]);

		Arrays.sort(lArr);
		Arrays.sort(rArr);

		long result = 0;
		int l = 0;
		int r = n * n - 1;
		
		while (l < n * n && r >= 0) {
			if (lArr[l] + rArr[r] > 0) {
				r--;
			} else if (lArr[l] + rArr[r] < 0) {
				l++;
			} else {
				int lCnt = 1;
				int rCnt = 1;
				
				while (l < n * n - 1 && (lArr[l] == lArr[l + 1])) {
					lCnt++;
					l++;
				}
				
				while (r - 1 >= 0 && (rArr[r] == rArr[r - 1])) {
					rCnt++;
					r--;
				}
				
				result += 1L * lCnt * rCnt;
				l++;
			}
		}
		
		System.out.println(result);
	}

	public static int[] calc(int[] arr1, int[] arr2) {
		int[] arr = new int[n * n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i * n + j] = arr1[i] + arr2[j];
			}
		}

		return arr;
	}
}
