import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] pastYear = new int[n];
			List<List<Integer>> graph = new ArrayList<>();
			int[] cnt = new int[n + 1];
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());

			// 작년 등수 입력 값
			for (int i = 0; i < n; i++) {
				pastYear[i] = Integer.parseInt(st1.nextToken());
				
				if (i > 0) {
					for (int j = i - 1; j >= 0; j--) {
						graph.get(pastYear[i]).add(pastYear[j]);
						cnt[pastYear[j]]++;
					}
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				if (graph.get(b).contains(a)) {
					graph.get(b).remove((Integer) a);
					cnt[a]--;
					graph.get(a).add(b);
					cnt[b]++;
				} else {
					graph.get(a).remove((Integer) b);
					cnt[b]--;
					graph.get(b).add(a);
					cnt[a]++;
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 1; i <= n; i++) {
				if (cnt[i] == 0) {
					q.add(i);
				}
			}
			
			while (!q.isEmpty()) {
				int cn = q.poll();
				list.add(cn);
				
				for (int nn : graph.get(cn)) {
					if (--cnt[nn] == 0) {
						q.add(nn);
					}
				}
			}
			
			boolean isEnd = true;
			
			for (int i = 1; i <= n; i++) {
				if (cnt[i] != 0) {
					isEnd = false;
					break;
				}
			}
			
			if (isEnd) {
				if (list.size() == n) {
					Collections.reverse(list);
					System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
				} else {
					System.out.println("?");
				}
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}