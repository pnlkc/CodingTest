import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> a[0] - b[0]);

		int num = 0;
		int pos = 0;

		for (int[] next : arr) {
			if (next[0] > pos) pos = next[0];
			if (next[1] > pos) {
				num += (next[1] - pos) / L;
				pos += (next[1] - pos) / L * L;
				if ((next[1] - pos) % L != 0) {
					num++;
					pos += L;
				}
			}
		}

		System.out.println(num);
	}
}