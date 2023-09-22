import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st1.nextToken());
			int E = Integer.parseInt(st1.nextToken());
			int[] cnt = new int[V + 1];
			List<List<Integer>> graph = new ArrayList<>();
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				graph.get(a).add(b);
				cnt[b]++;
			}
			
			Queue<Integer> pq = new LinkedList<>();
			
			for (int i = 1; i <= V; i++) {
				if (cnt[i] == 0) {
					pq.add(i);
				}
			}
			
			while (!pq.isEmpty()) {
				int cn = pq.poll();
				
				sb.append(" " + cn);
				
				for (int nn : graph.get(cn)) {
					if (--cnt[nn] == 0) {
						pq.add(nn);
					}
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}