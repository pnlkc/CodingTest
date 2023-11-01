import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq1 = new PriorityQueue<>(Comparator.comparing(Data::getS).thenComparing(Data::getE));
		PriorityQueue<Data> pq2 = new PriorityQueue<>(Comparator.comparing(Data::getE).thenComparing(Data::getS));
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			pq1.offer(new Data(s, e));
		}
		
		while (!pq1.isEmpty()) {
			Data c = pq1.poll();
			
			if (!pq2.isEmpty() && pq2.peek().e <= c.s) {
				pq2.poll();
			}
			
			pq2.offer(c);
		}
		
		System.out.println(pq2.size());
	}
}

class Data {
	int s, e;

	public int getS() {
		return s;
	}

	public int getE() {
		return e;
	}

	public Data(int s, int e) {
		this.s = s;
		this.e = e;
	}
}