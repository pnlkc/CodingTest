import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		List<List<Integer>> graph = new ArrayList<>(); // 그래프 리스트
		int[] cnt = new int[N + 1]; // 위상정렬 진입차수 배열
		
		// 그래프 NullPointerException 방지
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 그래프 초기화
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());
			graph.get(A).add(B);
			cnt[B]++;
		}
		
		// 위상 정렬 알고리즘 (Queue 대신 PriorityQueue를 사용하여 가장 쉬운 문제 부터 풀도록 구현)
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) {
				pq.add(i);
			}
		}
		
		while (!pq.isEmpty()) {
			int c = pq.poll();
			sb.append(c + " ");
			
			for (int n : graph.get(c)) {
				if (--cnt[n] == 0) {
					pq.add(n);
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}