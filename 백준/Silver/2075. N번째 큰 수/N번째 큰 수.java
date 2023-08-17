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
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pQueue.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < N - 1; i++) {
			pQueue.poll();
		}
		
		System.out.println(pQueue.poll());
	}
}