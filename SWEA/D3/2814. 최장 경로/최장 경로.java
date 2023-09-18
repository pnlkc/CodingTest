import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int n, d;

	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}

public class Solution {
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			List<List<Integer>> graph = new ArrayList<>();
			max = 1;
			
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				
				graph.get(x).add(y);
				graph.get(y).add(x);
			}
			
			for (int i = 1; i <= N; i++) {
				List<Integer> path = new ArrayList<>();
				path.add(i);
				dfs(graph, i, path);
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void dfs(List<List<Integer>> graph, int n, List<Integer> path) {
		max = Math.max(max, path.size());
		
		for (int nn : graph.get(n)) {
			if (!path.contains(nn)) {
				path.add(nn);
				dfs(graph, nn, path);
				path.remove(path.size() - 1);
			}
		}
	}
}