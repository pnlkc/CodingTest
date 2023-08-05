import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st1.nextToken());
		final int M = Integer.parseInt(st1.nextToken());
		List<List<Integer>> graph = new ArrayList<>(); // 그래프 배열
		int[] cnt = new int[N]; // 진입차수 배열

		// 그래프 배열 초기화
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		// 그래프 배열 값 추가
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken()) - 1; // 노드 번호와 인덱스 번호 차이 주의
			int b = Integer.parseInt(st2.nextToken()) - 1; // 노드 번호와 인덱스 번호 차이 주의
			graph.get(a).add(b); // 그래프에 추가
			cnt[b]++; // 진입 차수 추가

		}

		// 위상 정렬 알고리즘
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			if (cnt[i] == 0) { // 진입 차수가 0인 노드
				queue.add(i); // 큐에 추가
			}
		}

		while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
			int cn = queue.poll(); // 큐에서 차례대로 노드를 꺼냄
			sb.append(cn + 1).append(" ");

			for (int nn : graph.get(cn)) { // 현재 노드의 인접 노드 탐색
				if (--cnt[nn] == 0) { // 인접 노드의 진입 차수 1 감소 후 0이 되면 
					queue.add(nn); // 큐에 추가
				}
			}
		}
		
		System.out.println(sb.toString().trim()); // 마지막 공백 제거
	}
}