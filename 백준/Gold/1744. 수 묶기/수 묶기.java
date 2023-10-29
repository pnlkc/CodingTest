import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		int oneCnt = 0;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num <= 0) {
				pq1.offer(num);
			} else if (num == 1) {
				oneCnt++;
			} else {
				pq2.offer(num);
			}
		}
		
		int result = oneCnt;
		
		while (!pq1.isEmpty()) {
			if (pq1.size() > 1) {
				result += pq1.poll() * pq1.poll();
			} else {
				result += pq1.poll();
			}
		}
		
		while (!pq2.isEmpty()) {
			if (pq2.size() > 1) {
				result += pq2.poll() * pq2.poll();
			} else {
				result += pq2.poll();
			}
		}
		
		System.out.println(result);
	}
}