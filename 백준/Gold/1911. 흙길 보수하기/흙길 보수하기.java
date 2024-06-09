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
		int pos = arr[0][0] - 1;

		for (int[] next : arr) {
            if (next[1] - Math.max(next[0], pos) < 0) continue;
            
			int temp = (next[1] - Math.max(next[0], pos)) / L;
			if ((next[1] - Math.max(next[0], pos)) % L != 0)
				temp++;

			num += temp;
			pos = Math.max(next[0], pos) + L * temp;
		}

		System.out.println(num);
	}
}