import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double W = Double.parseDouble(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		int cnt = 0;
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			graph.get(U).add(V);
			graph.get(V).add(U);
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisit = new boolean[N + 1];
		
		q.add(1);
		isVisit[1] = true;
		
		while (!q.isEmpty()) {
			int c = q.poll();
			int num = 0;
			
			for (int next : graph.get(c)) {
				if (isVisit[next]) continue;
				
				num++;
				q.add(next);
				isVisit[next] = true;
			}
			
			if (num == 0) cnt++;
		}
		
		System.out.println(String.format("%.10f", W / cnt));
	}
}