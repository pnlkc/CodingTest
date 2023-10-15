import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>((Data d1, Data d2) -> d1.deadline - d2.deadline);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			pq.offer(new Data(d, w));
		}

		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		while (!pq.isEmpty()) {
			Data c = pq.poll();
			
			while (pq2.size() != c.deadline) {
				pq2.offer(0);
			}
			
			if (pq2.peek() < c.num) {
				pq2.poll();
				pq2.offer(c.num);
			}
		}
		
		int sum = 0;
		while (!pq2.isEmpty()) {
			sum += pq2.poll();
		}
		
		System.out.println(sum);
	}
}

class Data {
	int deadline, num;

	public Data(int deadline, int num) {
		this.deadline = deadline;
		this.num = num;
	}
}