import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		List<Integer> maxList = new ArrayList<>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());

			graph.get(B).add(A);
		}

		for (int i = 1; i <= N; i++) {
			boolean isVisit[] = new boolean[N + 1];
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			isVisit[i] = true;
			int cnt = 0;

			while (!q.isEmpty()) {
				int cn = q.poll();
				cnt++;

				for (int nn : graph.get(cn)) {
					if (!isVisit[nn]) {
						q.add(nn);
						isVisit[nn] = true;
					}
				}
			}
			
			if (max < cnt) {
				maxList.clear();
				max = cnt;
				maxList.add(i);
			} else if (max == cnt) {
				maxList.add(i);
			}
		}
		
		System.out.println(maxList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}