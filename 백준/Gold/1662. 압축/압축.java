import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		Stack<String> stack = new Stack<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String s = String.valueOf(str.charAt(i));
			
			if (s.equals(")")) {
				if (!stack.peek().equals("(")) {
					int num1 = Integer.parseInt(stack.pop());
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						num1 += Integer.parseInt(stack.pop());
					}
					stack.pop();
					int num2 = Integer.parseInt(stack.pop());
					
					int r = num1 * num2;
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						r += Integer.parseInt(stack.pop());
					}
					stack.push(String.valueOf(r));
				} else {
					stack.pop();
					stack.pop();
				}
			} else if (s.equals("(")) {
				stack.push(s);
			} else {
				if (i + 1 < N) {
					if (str.charAt(i + 1) == '(') {
						if (cnt != 0) stack.push(String.valueOf(cnt));
						cnt = 0;
						stack.push(s);
					} else if (str.charAt(i + 1) == ')') {
						stack.push(String.valueOf(cnt + 1));
						cnt = 0;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
			}
		}
		
		if (stack.isEmpty()) {
			System.out.println(cnt);
		} else {
			int sum = 0;
			while (!stack.isEmpty()) {
				sum += Integer.parseInt(stack.pop());
			}
			System.out.println(sum + cnt);
		}
	}
}