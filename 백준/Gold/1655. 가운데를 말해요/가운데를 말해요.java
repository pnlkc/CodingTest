import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder()); // 중간값까지 숫자를 담을 pq (내림차순)
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // 중간값 이후 숫자를 담을 pq (오름차순)
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine()); // 들어온 숫자
			
			if (pq1.size() > pq2.size()) { // pq2에 숫자를 넣을 차례
				if (num < pq1.peek()) { // pq1의 최대값이 들어온 숫자보다 큰 경우
					pq2.offer(pq1.poll()); // pq1의 최대값을 pq2로 이동
					pq1.offer(num); // pq1에 새로 들어온 숫자 추가
				} else { // pq1의 최대값이 들어온 숫자보다 작을 때
					pq2.offer(num); // pq2에 새로 들어온 숫자 추가
				}
			} else { // pq1에 숫자를 넣을 차례
				if (!pq2.isEmpty() && num > pq2.peek()) { // pq2가 비어있지 않고, 들어온 숫자가 pq2의 최소값보다 큰 경우
					pq1.offer(pq2.poll()); // pq2의 최소값을 pq1로 이동
					pq2.offer(num); // pq2에 새로 들어온 숫자 추가
				} else {
					pq1.offer(num); // pq1에 새로 들어온 숫자 추가
				}
			}
			
			sb.append(pq1.peek()).append("\n"); // pq1의 최대값이 전체의 중간값
		}
		
		System.out.println(sb);
	}
}