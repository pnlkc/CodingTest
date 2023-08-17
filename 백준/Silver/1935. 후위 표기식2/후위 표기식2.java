import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> calc = new HashMap<Character, Integer>() {
			{
				put('+', 1);
				put('-', 1);
				put('*', 2);
				put('/', 2);
				put('(', 0);
			}
		};
		Map<Character, Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		for (int i = 65; i < 65 + N; i++) {
			int num = Integer.parseInt(br.readLine());
			map.put((char) i, num);
		}
		
		Stack<Double> stack = new Stack<>();
	
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (calc.get(c) != null) {
				double b = stack.pop();
				double a = stack.pop();
			
				if (c == '*') {
					stack.push(a * b);
				} else if (c == '/') {
					stack.push(a / b);
				} else if (c == '+') {
					stack.push(a + b);
				} else {
					stack.push(a - b);
				}
			} else {
				stack.push((double) map.get(c));
			}
		}

		System.out.printf("%.2f", stack.pop());
	}
}