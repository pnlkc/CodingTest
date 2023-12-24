import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[H + 1];
		int[] arr2 = new int[H + 1];
		int min = Integer.MAX_VALUE;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (i % 2 == 0) {
				arr1[num]++;
			} else {
				arr2[num]++;
			}
		}

		for (int i = H; i >= 2; i--) {
			arr1[i - 1] += arr1[i];
			arr2[i - 1] += arr2[i];
		}
		
		for (int i = 1; i <= H; i++) {
			min = Math.min(min, arr1[i] + arr2[H - i + 1]);
		}
		
		for (int i = 1; i <= H; i++) {
			if (min == arr1[i] + arr2[H - i + 1]) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
	}
}