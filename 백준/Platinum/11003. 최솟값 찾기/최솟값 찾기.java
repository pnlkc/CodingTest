import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Data {
	int idx, num;

	public Data(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int L = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		Deque<Data> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st2.nextToken());

			if (!dq.isEmpty() && dq.peekFirst().idx < i - L + 1) {
				dq.pollFirst();
			}

			while (!dq.isEmpty() && dq.peekLast().num > num) {
				dq.pollLast();
			}

			dq.offerLast(new Data(i, num));

			sb.append(dq.peekFirst().num);
			
			if (i != N - 1) {
				sb.append(" ");
			}
		}

		System.out.println(sb);
	}
}