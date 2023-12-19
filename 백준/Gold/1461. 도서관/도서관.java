import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
		int result = 0;
		int maxMinus = 0;
		int maxPlus = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num > 0) {
				plus.offer(num);
			} else {
				minus.offer(num);
			}
		}
		
		if (!minus.isEmpty()) {
			maxMinus = -minus.peek();
		}
		
		if (!plus.isEmpty()) {
			maxPlus = plus.peek();
		}
		
		if (maxMinus > maxPlus) {
			result -= minus.poll();
			
			for (int i = 0; i < M - 1; i++) {
				if (!minus.isEmpty()) {
					minus.poll();
				}
			}
		} else {
			result += plus.poll();
			
			for (int i = 0; i < M - 1; i++) {
				if (!plus.isEmpty()) {
					plus.poll();
				}
			}
		}
		
		while (!minus.isEmpty()) {
			result -= minus.poll() * 2;
			
			for (int i = 0; i < M - 1; i++) {
				if (!minus.isEmpty()) {
					minus.poll();
				}
			}
		}
		
		while (!plus.isEmpty()) {
			result += plus.poll() * 2;
			
			for (int i = 0; i < M - 1; i++) {
				if (!plus.isEmpty()) {
					plus.poll();
				}
			}
		}
		
		System.out.println(result);
	}
}