import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		UnionFind uf = new UnionFind(N);
		int[] costs = new int[N + 1];
		Map<Integer, List<Integer>> map = new HashMap<>();
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		// 친구 그룹을 생성하는 과정
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			uf.union(v, w);
		}
		
		// 친구 그룹 별로 분리하는 과정
		for (int i = 1; i <= N; i++) {
			int p = uf.find(i);
			
			if (map.get(p) == null) {
				map.put(p, new ArrayList<>());
			}
			
			map.get(p).add(i);
		}
		
		// 각 친구 그룹 중 친구비의 최솟값을 구하는 과정
		for (int key : map.keySet()) {
			int min = Integer.MAX_VALUE;
			
			for (int num : map.get(key)) {
				min = Integer.min(min, costs[num]);
			}
			
			sum += min;
		}
		
		if (sum > k) { // 친구비가 모자른 경우
			System.out.println("Oh no");
		} else { // 친구비 예산 안에서 친구를 다 사귈 수 있는 경우
			System.out.println(sum);
		}
	}
}

// 유니온 파인드 클래스
class UnionFind {
	int[] parent, rank;
	boolean[] isVisit;
	
	public UnionFind(int N) {
		parent = new int[N + 1];
		rank = new int[N + 1];
		isVisit = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
 	}
	
	public int find(int node) {
		if (parent[node] != node) {
			return parent[node] = find(parent[node]);
		}
		
		return parent[node];
	}
	
	public void union(int node1, int node2) {
		int p1 = find(node1);
		int p2 = find(node2);
		
		if (p1 == p2) {
			return;
		}
		
		isVisit[p1] = true;
		isVisit[p2] = true;
		
		if (p1 > p2) {
			parent[p2] = p1;
		} else if (p1 < p2) {
			parent[p1] = p2;
		} else {
			parent[p2] = p1;
			rank[p1]++;
		}
	}
}