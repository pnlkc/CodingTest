import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> graph = new ArrayList<>();
		int[] times = new int[N + 1];
		int[] cnt = new int[N + 1];
		Queue<Data> q = new LinkedList<>();
		int[] isVisit = new int[N + 1];
		int result = 0;
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			times[i] = time;
			
			for (int j = 0; j < num; j++) {
				int next = Integer.parseInt(st.nextToken());
				graph.get(next).add(i);
				cnt[i]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) {
				q.offer(new Data(i, times[i]));
				isVisit[i] = times[i];
			}
		}
		
		while (!q.isEmpty()) {
			Data c = q.poll();
			
			result = Math.max(result, c.time);
			
			for (int next : graph.get(c.num)) {
				if (isVisit[next] < c.time + times[next]) {
					isVisit[next] = c.time + times[next];
				}
				
				if (--cnt[next] == 0) {
					q.offer(new Data(next, isVisit[next]));
				}
			}
		}
		
		System.out.println(result);
	}
}

class Data {
	int num, time;

	public Data(int num, int time) {
		this.num = num;
		this.time = time;
	}
}