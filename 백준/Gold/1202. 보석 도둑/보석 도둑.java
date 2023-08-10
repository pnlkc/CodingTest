import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel {
	int m, v;

	public int getM() {
		return m;
	}

	public int getV() {
		return v;
	}

	public Jewel(int m, int v) {
		this.m = m;
		this.v = v;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		
		PriorityQueue<Jewel> jewelList = new PriorityQueue<>(Comparator.comparing(Jewel::getM)
				.thenComparing(Jewel::getV, Comparator.reverseOrder()));
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			jewelList.offer(new Jewel(m, v));
		}
		
		PriorityQueue<Integer> bagList = new PriorityQueue<>();
		for (int i = 0; i < K; i++) {
			bagList.add(Integer.parseInt(br.readLine()));
		}
		
		PriorityQueue<Jewel> tempList = new PriorityQueue<>(Comparator.comparing(Jewel::getV, Comparator.reverseOrder()));
		
		long sum = 0;
		while (!bagList.isEmpty()) {
			int bag = bagList.poll();
			
			while(!jewelList.isEmpty() && jewelList.peek().m <= bag) {
				tempList.add(jewelList.poll());
			}
			
			if (!tempList.isEmpty()) {
				sum += tempList.poll().v;
			}
		}
		
		System.out.println(sum);
	}
}