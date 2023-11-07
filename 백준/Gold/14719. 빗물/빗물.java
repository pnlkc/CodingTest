import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < W; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (dq.isEmpty()) {
				dq.offer(num);
			} else {
				if (dq.peekFirst() < num) {
					int min = dq.pollFirst();
					
					while (!dq.isEmpty()) {
						result += min - dq.pollFirst();
					}
					
					dq.offer(num);
				} else {
					dq.offer(num);
				}
			}
		}
		
		if (!dq.isEmpty()) {
			int max = dq.peekLast();
			max = Math.min(max, dq.pollFirst());
			
			while (!dq.isEmpty()) {
				max = Math.max(max, dq.peekLast());
				
				result += max - dq.pollLast();
			}
		}
		
		System.out.println(result);
	}
}