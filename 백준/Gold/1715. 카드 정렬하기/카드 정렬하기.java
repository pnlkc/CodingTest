import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int r = 0;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			r += a + b;
			pq.offer(a + b);
		}
		
		System.out.println(r);
	}
}