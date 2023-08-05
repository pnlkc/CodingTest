import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상 정렬(Topological Sort)은 그래프를 정렬(탐색)하는 알고리즘 중 하나입니다 
 * 위상 정렬은 노드의 선후관계(탐색 순서)가 정해진 그래프를 탐색하는데 사용되는 알고리즘입니다
 * 방향성을 거스르지 않게 정점들을 나열할 수 있기 때문에 정렬 알고리즘으로 분류가 됩니다
 * 
 * 위상 정렬에는 진입차수(in-degree)와 진출차수(out-degree)라는 용어가 사용됩니다 
 * 진입차수는 다른 노드에서 현재의 노드로 들어오는 간선의 개수를 의미합니다 
 * 진출차수는 현재 노드에서 다른 노드로 나가는 간선의 개수를 의미합니다
 * 
 * 위상 정렬의 과정은 다음과 같습니다 
 * 1. 그래프에 맞춰 함께 진입차수 배열을 생성합니다 
 * 2. 진입 차수가 0인 노드를 큐에 넣습니다 (이 때 노드의 순서는 상관 없습니다) 
 * 3. 큐에서 차례대로 노드를 꺼내도 연결된 노드들의 진입 차수를 1씩 감소시킵니다 
 * 4. 진입 차수가 0이 되면 해당 노드를 큐에 넣습니다 
 * 5. 큐가 비어 있지 않은 경우 반복합니다
 * 
 * ex) 백준 2252번 줄 세우기
 */
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
			sb.append(cn + 1).append(" "); // 노드 번호와 인덱스 번호 차이 주의

			for (int nn : graph.get(cn)) { // 현재 노드의 인접 노드 탐색
				if (--cnt[nn] == 0) { // 인접 노드의 진입 차수 1 감소 후 0이 되면 
					queue.add(nn); // 큐에 추가
				}
			}
		}
		
		System.out.println(sb.toString().trim()); // 마지막 공백 제거
	}
}
