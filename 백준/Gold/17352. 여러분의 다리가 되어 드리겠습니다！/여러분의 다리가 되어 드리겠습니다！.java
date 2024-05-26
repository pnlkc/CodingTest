import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisit = new boolean[N + 1];

		q.offer(1);
		isVisit[1] = true;

		while (!q.isEmpty()) {
			int c = q.poll();

			for (int next : graph.get(c)) {
				if (isVisit[next])
					continue;

				q.offer(next);
				isVisit[next] = true;
			}
		}
		
		if (!isVisit[1]) {
			System.out.println("1 2");
		} else {
			for (int i = 2; i <= N; i++) {
				if (!isVisit[i]) {
					System.out.println("1 " + i);
					break;
				}
			}
		}
	}
}