import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph;
	static boolean isPossible = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 0; i < N; i++) {
			boolean[] isVisit = new boolean[N];
			dfs(i, 1, isVisit);
		}
		
		if (isPossible) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void dfs(int n, int depth, boolean[] isVisit) {
		if (isPossible) {
			return;
		}
		
		if (depth == 5) {
			isPossible = true;
			return;
		}
		
		isVisit[n] = true;
		
		for (int next : graph.get(n)) {
			if (!isVisit[next]) {
				dfs(next, depth + 1, isVisit);
			}
		}
		
		isVisit[n] = false;
	}
}