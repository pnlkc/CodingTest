import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<String> s = new Stack<>();
		Map<String, String> map = new HashMap<>();
		map.put(")", "(");
		map.put("(", "2");
		map.put("]", "[");
		map.put("[", "3");

		for (int i = 0; i < str.length(); i++) {
			String c = String.valueOf(str.charAt(i));

			if (c.equals("(") || c.equals("[")) { // 여는 괄호인 경우
				s.push(c);
			} else { // 닫는 괄호인 경우
				if (!s.isEmpty() && s.peek().equals(map.get(c))) { // 소괄호 짝이 맞는 경우
					s.pop();
					s.push(map.get(map.get(c)));
				} else if (s.isEmpty() || map.get(s.peek()) != null) { // 짝이 맞지 않는 경우
					System.out.println(0);
					return;
				} else { // 앞에 숫자가 있는 경우
					int num = 0;

					// 앞에 숫자가 없을 때까지 반복
					while (!s.isEmpty() && Character.isDigit(s.peek().charAt(0))) {
						num += Integer.parseInt(s.pop());
					}

					if (s.isEmpty() || (!map.get(c).equals(s.peek()) && map.get(s.peek()) != null)) { // 올바르지 못한 괄호열인 경우
						System.out.println(0);
						return;
					}

					s.pop();
					s.push(String.valueOf(num * Integer.parseInt(map.get(map.get(c)))));
				}
			}
		}

		int result = 0;
		
		// stack에 남은 요소들 계산
		while (!s.isEmpty()) {
			if (Character.isDigit(s.peek().charAt(0))) {
				result += Integer.parseInt(s.pop());
			} else { // 올바르지 못한 괄호열인 경우
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(result);
	}
}