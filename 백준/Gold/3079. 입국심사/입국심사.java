import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long[] list = new long[(int) N];

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(list);

		long s = 1;
		long e = M * list[list.length - 1];

		while (s < e) {
			long mid = (s + e) / 2;
			long num = 0;

			for (long i : list) {
				num += mid / i;
				if (num >= M) break;
			}

			if (num >= M) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		long mid = (s + e) / 2;
		long num = 0;

		for (long i : list) {
			num += mid / i;
			if (num >= M) break;
		}

		if (num < M)
			mid++;

		System.out.println(mid);

	}
}