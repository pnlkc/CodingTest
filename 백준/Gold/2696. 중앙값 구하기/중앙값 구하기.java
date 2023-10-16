import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int M = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> pq2 = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int half = M / 2;
			if (M % 2 == 1) {
				half++;
			}
			sb.append(half + "\n");
			
			for (int i = 1; i <= M; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (pq1.size() > pq2.size()) {
					if (!pq1.isEmpty() && pq1.peek() > num) {
						pq2.offer(pq1.poll());
						pq1.offer(num);
					} else {
						pq2.offer(num);
					}
				} else {
					if (!pq2.isEmpty() && pq2.peek() < num) {
						pq1.offer(pq2.poll());
						pq2.offer(num);
					} else {
						pq1.offer(num);
					}
				}
				
				if (i % 2 == 1) {
					sb.append(pq1.peek());
					
					if (i % 19 != 0 && i != M) {
						sb.append(" ");
					} else {
						sb.append("\n");
					}
				}
				
				if (i != 0 && i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
			}
		}
		
		System.out.print(sb);
	}
}