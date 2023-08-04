import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				int num2 = Integer.parseInt(st.nextToken());
				stack.add(num2);
			} else if (num == 2) {
				if (stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.pop()).append("\n");
			} else if (num == 3) {
				sb.append(stack.size()).append("\n");
			} else if (num == 4) {
				if (stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			} else {
				if (stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.peek()).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}