import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Data {
	int num;
	double time;

	public Data(int num, double time) {
		this.num = num;
		this.time = time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				if (o1.time == o2.time) {
					return o1.num - o2.num;
				} else {
					if (o1.time > o2.time) {
						return 1;
					} else if (o1.time < o2.time) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq.offer(new Data(i + 1, calc(x, y) / (v * v)));
		}
		
		while (!pq.isEmpty()) {
			sb.append(pq.poll().num).append("\n");
		}
		
		System.out.println(sb);
	}

	public static double calc(int x, int y) {
		return x * x + y * y;
	}
}