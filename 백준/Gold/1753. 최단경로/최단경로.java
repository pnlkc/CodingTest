import java.io.*;
import java.util.*;

// 클래스명은 대문자 시작(파스칼 케이스)
class vertex implements Comparable<vertex> {
	int v, u, e;// 각각 시작 노드, 도착 노드, 간선정보

	public vertex(int v, int u, int e) {
		this.v = v;
		this.u = u;
		this.e = e;
	}

	@Override
	public int compareTo(vertex o) {
		if (v == o.v) {// 시작 정점 번호가 같고
			return e - o.e;
		}
		// 시작 정점 번호가 다르면 v로 오름차순 정렬
		return v - o.v;
	}
}

class Dist implements Comparable<Dist> {
	int n, d;

	public Dist(int n, int d) {
		this.n = n;
		this.d = d;
	}

	@Override
	public int compareTo(Dist o) {
		return d - o.d;
	}
}

public class Main {

	public static int N, M, start;
	public static int max = Integer.MAX_VALUE - 1;
	public static StringTokenizer st;
	public static int[] d_dist;
	public static boolean[] visit;
//	public static Queue<Integer> q = new LinkedList<>();
	public static PriorityQueue<Dist> pq = new PriorityQueue<>();
	public static ArrayList<ArrayList<vertex>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 정점의 개수
		M = Integer.parseInt(st.nextToken());// 정점의 개수
		start = Integer.parseInt(br.readLine());// 시작 정점 번호

		visit = new boolean[N + 1];

		d_dist = new int[N + 1];
		Arrays.fill(d_dist, max);

		d_dist[start] = 0;

		// 정점마다 정보를 담을 공간 생성
		// 0은 빈 공간
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<vertex>());
		}

		// 그래프 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			vertex tmp = new vertex(v, u, e);

			graph.get(v).add(tmp);// 인덱스 정보 = 시작 정점
		}
		
		// 오름차순 정렬
//		for (int i = 1; i <= N; i++) {
//			Collections.sort(graph.get(i));
//		}

		dijkstra();

		for (int i = 1; i <= N; i++) {
			if (d_dist[i] == max)
				System.out.println("INF");
			else {
				System.out.println(d_dist[i]);
			}
		}
	}

	public static void dijkstra() {

//		q.add(start);
		
		pq.offer(new Dist(start, 0));

		while (!pq.isEmpty()) {
//			int tmp_v = q.poll();
			Dist c = pq.poll();
			
			if (visit[c.n]) continue; // 방문한 노드면 continue;
			visit[c.n] = true;
			
			for (int i = 0; i < graph.get(c.n).size(); i++) {
				int v = graph.get(c.n).get(i).v;
				int u = graph.get(c.n).get(i).u;
				int e = graph.get(c.n).get(i).e;
				
//				q.offer(u);
				// 현재 정점까지의 최소거리 + 도착 정점까지의 거리가
				// 현재 도착 정점의 최소거리 배열 값보다 작을 때
				if (!visit[u] && d_dist[v] + e < d_dist[u]) {
					d_dist[u] = d_dist[v] + e;
					pq.offer(new Dist(u, d_dist[u]));
				}
				// 다음 정점에서 또 탐색
			}

		}

	}
}