import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>((Data d1, Data d2) -> d1.d - d2.d);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			pq.add(new Data(d, w));
		}

		int[] result = new int[1_001];
		
		while (!pq.isEmpty()) {
			Data c = pq.poll();
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			
			for (int i = 1; i <= c.d; i++) {
				if (result[i] < c.w && result[i] < min) {
					min = result[i];
					minIdx = i;
				}
			}
			
			if (minIdx != -1) {
				result[minIdx] = c.w;
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= 1_000; i++) {
			sum += result[i];
		}
		
		System.out.println(sum);
	}
}

class Data {
	int d, w;

	public Data(int d, int w) {
		this.d = d;
		this.w = w;
	}
}