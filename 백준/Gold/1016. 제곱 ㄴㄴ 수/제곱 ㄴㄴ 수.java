import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		long sqrt = (long) Math.sqrt(max);

		boolean[] arr = new boolean[(int) (sqrt + 1)];
		boolean[] result = new boolean[(int) (max - min + 1)];

		for (int i = 2; i <= sqrt; i++) {
			if (arr[i]) {
				continue;
			}

			long num = (long) i * i;

			if (num <= sqrt) {
				arr[(int) num] = true;
			}

			for (long j = min / num; j <= max / num; j++) {
				if (num * j >= min) {
					result[(int) (num * j - min)] = true;
				}
			}
		}

		int cnt = 0;

		for (boolean r : result) {
			if (!r) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}