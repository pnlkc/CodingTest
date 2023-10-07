import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N;
	static long max = Integer.MIN_VALUE;
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();

		if (N == 1) {
			System.out.println(str);
			return;
		}
		
		Deque<String> deque = new ArrayDeque<>();
		deque.add(String.valueOf(str.charAt(0)));
		calc(2, deque, true);

		System.out.println(max);
	}

	public static void calc(int idx, Deque<String> deque, boolean canCalc) {
		if (idx >= N) {
			long num = Long.parseLong(deque.pollFirst());

			while (!deque.isEmpty()) {
				String operator = deque.pollFirst();

				if (operator.equals("+")) {
					num += Long.parseLong(deque.pollFirst());
				} else if (operator.equals("-")) {
					num -= Long.parseLong(deque.pollFirst());
				} else {
					num *= Long.parseLong(deque.pollFirst());
				}
			}

			max = Math.max(max, num);

			return;
		}

		ArrayDeque<String> temp1 = new ArrayDeque<>(deque);
		ArrayDeque<String> temp2 = new ArrayDeque<>(deque);


		if (canCalc) {
			char operator = str.charAt(idx - 1);
			
			if (operator == '+') {
				temp1.offerLast(String.valueOf(Long.parseLong(temp1.pollLast()) + (str.charAt(idx) - '0')));
			} else if (operator == '-') {
				temp1.offerLast(String.valueOf(Long.parseLong(temp1.pollLast()) - (str.charAt(idx) - '0')));
			} else {
				temp1.offerLast(String.valueOf(Long.parseLong(temp1.pollLast()) * (str.charAt(idx) - '0')));
			}
			
			calc(idx + 2, temp1, false);
		} else {
			temp1.offerLast(String.valueOf(str.charAt(idx - 1)));
			temp1.offerLast(String.valueOf(str.charAt(idx)));
			calc(idx + 2, temp1, true);
		}
		
		temp2.offerLast(String.valueOf(str.charAt(idx - 1)));
		temp2.offerLast(String.valueOf(str.charAt(idx)));
		calc(idx + 2, temp2, true);
	}
}