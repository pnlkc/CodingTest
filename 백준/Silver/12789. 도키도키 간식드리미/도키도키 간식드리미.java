import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 1;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			int next = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek() == num) {
				stack.pop();
				num++;
			}

			if (next != num)
				stack.push(next);
			else
				num++;

			while (!stack.isEmpty() && stack.peek() == num) {
				stack.pop();
				num++;
			}
		}

		if (stack.isEmpty()) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}