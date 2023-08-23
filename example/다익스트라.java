import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 다익스트라 (Dijkstra)
 * 
 * 시작 노드에서 다른 모든 노드까지의 최단거리를 구하는 알고리즘
 * 간선이 음수일 때는 사용할 수 없는 알고리즘 (간선이 음수일 때는 벨만-포드 알고리즘 사용)
 * 시간복잡도는 V(정점의 수), E(간선의 수)일 때, O((E + V)logV
 * ex) 백준 1753번 최단경로
 */
public class Dijkstra {
	// v = 노드 개수 , e = 간선 개수, s = 시작 노드
	public static void dijkstra(int v, int e, int s, List<List<ND>> graph) {
		int[] dist = new int[v + 1]; // 노드의 최소 거리를 담을 배열
		Arrays.fill(dist, Integer.MAX_VALUE);
//		Arrays.fill(dist, -1);
		boolean[] isVisit = new boolean[v + 1]; // 방문 여부 체크
		
		// Comparator 람다식 사용
		PriorityQueue<ND> pq = new PriorityQueue<>((ND o1, ND o2) -> o1.d - o2.d);
		
		pq.add(new ND(s, 0)); // pq에 시작 노드 추가
		dist[s] = 0; // 시작 노드 거리 0으로 초기화
		
		while (!pq.isEmpty()) {
			ND c = pq.poll(); // 경유할 노드
			
			if (isVisit[c.n]) continue; // 방문한 노드면 continue
			isVisit[c.n] = true; // 현재 노드를 방문했다고 변경
			
//			if (dist[c.n] != -1 && c.d > dist[c.n]) { // 이미 더 짧은 경로가 존재하는 경우
//				continue;
//			}
			
			for (ND n : graph.get(c.n)) { // 경유할 노드와 인접한 노드 탐색
				if (dist[n.n] > dist[c.n] + n.d) { // 경유하는 것이 더 짧은 경로인 경우
					dist[n.n] = dist[c.n] + n.d; // 거리 갱신
					pq.offer(new ND(n.n, dist[n.n])); // pq에 추가
				}
				
//				if (dist[n.n] == -1 || dist[n.n] > dist[c.n] + n.d) { // 경유하는 것이 더 짧은 경로인 경우
//					dist[n.n] = dist[c.n] + n.d; // 거리 갱신
//					pq.offer(new ND(n.n, dist[n.n])); // pq에 추가
//				}
			}
		}
	}
}

class ND {
	int n, d; // n = 노드 번호, d = 거리

	public ND(int n, int d) {
		super();
		this.n = n;
		this.d = d;
	}
}
