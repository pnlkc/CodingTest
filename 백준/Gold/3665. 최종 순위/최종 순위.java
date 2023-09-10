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
			
			// graph 접근시 NullPointerException 방지
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());

			// 작년 등수 입력 값
			for (int i = 0; i < n; i++) {
				pastYear[i] = Integer.parseInt(st1.nextToken());
				
				if (i > 0) { // 자신보다 높은 등수의 팀들과 간선 연결
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
				
				if (graph.get(b).contains(a)) { // a가 더 높은 등수였던 경우
					graph.get(b).remove((Integer) a);
					cnt[a]--;
					graph.get(a).add(b);
					cnt[b]++;
				} else { // b가 더 높은 등수였던 경우
					graph.get(a).remove((Integer) b);
					cnt[b]--;
					graph.get(b).add(a);
					cnt[a]++;
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			// 진입차수가 0인 팀(노드)를 큐에 추가
			for (int i = 1; i <= n; i++) {
				if (cnt[i] == 0) {
					q.add(i);
				}
			}
			
			// 큐가 빌 때까지 반복
			while (!q.isEmpty()) {
				int cn = q.poll();
				list.add(cn);
				
				for (int nn : graph.get(cn)) {
					if (--cnt[nn] == 0) {
						q.add(nn);
					}
				}
			}
			
			boolean isEnd = true; // 등수를 알 수 있는지 확인하는 변수
			
			for (int i = 1; i <= n; i++) {
				if (cnt[i] != 0) { // 데이터에 일관성이 없어서 순위를 정할 수 없는 경우
					isEnd = false;
					break;
				}
			}
			
			if (isEnd) {
				if (list.size() == n) { // 모든 팀의 순위를 알 수 있는 경우
					Collections.reverse(list); // 낮은 등 수 부터 역순으로 입력되었으므로 reverse 필요
					System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
				} else { // 모든 팀의 확실한 순위를 찾을 수 없는 경우
					System.out.println("?");
				}
			} else { // 데이터에 일관성이 없어서 순위를 정할 수 없는 경우
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}