import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int num = str.charAt(i) - '0';
			
			while (cnt < K && !stack.isEmpty() && stack.peek() < num) {
				stack.pop();
				cnt++;
			}
			
			stack.add(num);
		}
		
		while (cnt++ < K) {
			stack.pop();
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		sb.reverse();
		
		System.out.println(sb);
	}
}