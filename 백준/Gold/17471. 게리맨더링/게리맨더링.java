import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int diff = Integer.MAX_VALUE;
	static int[] populations;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		populations = new int[n];

		// 인구수 저장
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			populations[i] = Integer.parseInt(st1.nextToken());
		}

		// 그래프 생성
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st2.nextToken());

			if (graph[i] == null) {
				graph[i] = new ArrayList<Integer>();
			}

			for (int j = 0; j < num; j++) {
				graph[i].add(Integer.parseInt(st2.nextToken()) - 1);
			}
		}
		
		// 조합에 따라 실행
		for (int i = 1; i <= n / 2; i++) {
			combination(0, new ArrayList<Integer>(), n, i);
		}
		
		if (diff == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(diff);
	}
	
	
	public static void combination(int idx, ArrayList<Integer> g1, int n, int limit) {
		if (g1.size() == limit) {
			ArrayList<Integer> g2 = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				if (!g1.contains(i)) {
					g2.add(i);
				}
			}
			
			// 그룹 1, 2 체크
			if (check(g1, g2) && check(g2, g1)) {
				int sum1 = 0;
				for (int i : g1) {
					sum1 += populations[i];
				}
				
				int sum2 = 0;
				for (int i : g2) {
					sum2 += populations[i];
				}
				
				diff = Math.min(diff, Math.abs(sum1 - sum2));
			}
		} else {
			for (int i = idx; i < n; i++) {
				if (!g1.contains(i)) {
					g1.add(i);
					combination(i, g1, n, limit);
					g1.remove(g1.size() - 1);
				}
			}
		}
	}
	
	public static void dfs(int node, boolean[] visit) {
		// 노드를 방문했다고 표시
		visit[node] = true;
		
		// 인접 노드 탐색
		for (int nNode : graph[node]) {
			if (!visit[nNode]) {
				dfs(nNode, visit);
			}
		}
	}
	
	public static boolean check(ArrayList<Integer> g1, ArrayList<Integer> g2) {
		boolean[] isVisit = new boolean[graph.length];
		
		for (int node : g1) {
			isVisit[node] = true;
		}
		
		// g[0]에서 dfs를 돌림
		dfs(g2.get(0), isVisit);
		
		// g에 포함된 값중 거치지 않는 값이 있는지 확인
		for (int node : g2) {
			if (!isVisit[node]) return false;
		}
		
		return true;
	}
}