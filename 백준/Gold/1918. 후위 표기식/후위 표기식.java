import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		HashMap<Character, String> map = new HashMap<>();
		map.put(')', "+-*/");
		map.put('+', "+-*/");
		map.put('-', "+-*/");
		map.put('*', "*/");
		map.put('/', "*/");
		
		for (char c : input.toCharArray()) {
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!s.isEmpty() && map.get(c).contains(s.peek().toString())) {
					sb.append(s.pop());
				}
				s.add(c);
			} else if (c == ')') {
				while (!s.isEmpty() && map.get(c).contains(s.peek().toString())) {
					sb.append(s.pop());
				}
				s.pop();
			} else if (c == '(') {
				s.add(c);
			} else {
				sb.append(c);
			}
		}
		
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}

		System.out.println(sb);
	}
}