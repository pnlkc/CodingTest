import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<String> s = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			String c = String.valueOf(str.charAt(i));

			if (c.equals("(") || c.equals("[")) { // 여는 괄호인 경우
				s.push(c);
			} else { // 닫는 괄호인 경우
				if (c.equals(")")) { // 소괄호 인 경우
					if (!s.isEmpty() && s.peek().equals("(")) { // 소괄호 짝이 맞는 경우
						s.pop();
						s.push("2");
					} else if (s.isEmpty() || s.peek().equals("[")) { // 짝이 맞지 않는 경우
						System.out.println(0);
						return;
					} else {
						int num = 0;

						while (!s.isEmpty() && Character.isDigit(s.peek().charAt(0))) {
							num += Integer.parseInt(s.pop());
						}

						if (s.isEmpty() || s.peek().equals("[")) {
							System.out.println(0);
							return;
						}

						s.pop();
						s.push(String.valueOf(num * 2));
					}
				} else { // 대괄호인 경우
					if (!s.isEmpty() && s.peek().equals("[")) { // 대괄호 짝이 맞는 경우
						s.pop();
						s.push("3");
					} else if (s.isEmpty() || s.peek().equals("(")) { // 짝이 맞지 않는 경우
						System.out.println(0);
						return;
					} else {
						int num = 0;

						while (!s.isEmpty() && Character.isDigit(s.peek().charAt(0))) {
							num += Integer.parseInt(s.pop());
						}

						if (s.isEmpty() || s.peek().equals("(")) {
							System.out.println(0);
							return;
						}

						s.pop();
						s.push(String.valueOf(num * 3));
					}
				}
			}
		}

		int result = 0;
		
		while (!s.isEmpty()) {
			if (Character.isDigit(s.peek().charAt(0))) {
				result += Integer.parseInt(s.pop());
			} else {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(result);
	}
}