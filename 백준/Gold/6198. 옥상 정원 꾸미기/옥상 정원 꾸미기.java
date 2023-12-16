import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		long sum = 0;
		
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());

			while (!s.isEmpty() && s.peek() <= h) {
				s.pop();
			}
			
			sum += s.size();
			s.push(h);
			
		}

		System.out.println(sum);
	}
}