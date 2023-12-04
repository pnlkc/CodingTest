import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Pos> pq = new PriorityQueue<>((Pos p1, Pos p2) -> p1.s - p2.s);
		int sum = 0;
		int S = Integer.MIN_VALUE;
		int E = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.offer(new Pos(x, y));
		}
		
		for (int i = 0; i < N; i++) {
			Pos c = pq.poll();
			
			if (c.s <= E) {
				if (c.e > E) {
					E = c.e;
				}
			} else {
				sum += E - S;
				S = c.s;
				E = c.e;
			}
		}
		
		sum += E - S;
		
		System.out.println(sum);
	}
}

class Pos {
	int s, e;

	public Pos(int s, int e) {
		this.s = s;
		this.e = e;
	}
}