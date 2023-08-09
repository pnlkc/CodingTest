import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int n, t;

	public Node(int n, int t) {
		this.n = n;
		this.t = t;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] cnt = new int[N];
		int end = 0;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st2.nextToken());
			int pre = -1;
			
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st2.nextToken()) - 1;
				if (j != 0) {
					if (graph.get(pre) == null) graph.put(pre, new ArrayList<>());
					graph.get(pre).add(num);
					cnt[num]++;
				}
				pre = num;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			if (cnt[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int cn = queue.poll();
			end++;
			sb.append(cn + 1).append("\n");
			
			if (graph.get(cn) != null) {
				for (int nn : graph.get(cn)) {
					if (--cnt[nn] == 0) {
						queue.add(nn);
					}
				}
			}
		}
		
		if (end == N) System.out.println(sb);
		else System.out.println(0);
	}
}