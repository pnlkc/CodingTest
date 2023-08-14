import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			deque.offerLast(new int[] { i, Integer.parseInt(st.nextToken()) });
		}

		for (int i = 0; i < N; i++) {
			int[] c = deque.pollFirst();
			int num = c[1];
			sb.append(c[0]);
			if (i == N - 1)
				break;
			else 
				sb.append(" ");
			
			if (num < 0) {
				for (int j = 0; j < -num; j++) {
					deque.offerFirst(deque.pollLast());
				}
			} else {
				for (int j = 0; j < num - 1; j++) {
					deque.offerLast(deque.pollFirst());
				}
			}
		}

		System.out.println(sb.toString().trim());
	}
}