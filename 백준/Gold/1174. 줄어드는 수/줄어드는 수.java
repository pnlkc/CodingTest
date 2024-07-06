import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Long> set = new HashSet<>();

		calc(set, 0, 9);

		Long[] arr = set.stream().sorted().toArray(Long[]::new);
		
		if (arr.length < N) {
			System.out.println(-1);
		} else {
			System.out.println(arr[N - 1]);
		}
	}

	public static void calc(Set<Long> set, long num, int last) {
		if (last < 0) {
			set.add(num);
			return;
		}

		calc(set, num * 10 + last, last - 1);
		calc(set, num, last - 1);
	}
}