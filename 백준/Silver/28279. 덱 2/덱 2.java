import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				deque.offerFirst(Integer.parseInt(st.nextToken()));
			} else if (command == 2) {
				deque.offerLast(Integer.parseInt(st.nextToken()));
			} else if (command == 3) {
				if (!deque.isEmpty()) {
					sb.append(deque.pollFirst()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if (command == 4) {
				if (!deque.isEmpty()) {
					sb.append(deque.pollLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if (command == 5) {
				sb.append(deque.size()).append("\n");
			} else if (command == 6) {
				if (!deque.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
			} else if (command == 7) {
				if (!deque.isEmpty()) {
					sb.append(deque.peekFirst()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else {
				if (!deque.isEmpty()) {
					sb.append(deque.peekLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}