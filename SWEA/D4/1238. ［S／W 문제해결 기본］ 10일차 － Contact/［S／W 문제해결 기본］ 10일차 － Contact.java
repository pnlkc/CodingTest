import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int n, d;

	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st1.nextToken());
			int S = Integer.parseInt(st1.nextToken());
			List<List<Integer>> graph = new ArrayList<>();
			
			for (int i = 0; i <= 100; i++) {
				graph.add(new ArrayList<>());
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < L / 2; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				graph.get(a).add(b);
			}
			
			int[] dist = new int[101];
			Arrays.fill(dist, -1);
			PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.d - n2.d);
			pq.add(new Node(S, 0));
			dist[S] = 0;
			
			while (!pq.isEmpty()) {
				Node c = pq.poll();
						
				for (int nn : graph.get(c.n)) {
					if (dist[nn] == -1 || dist[nn] > dist[c.n] + 1) {
						dist[nn] = dist[c.n] + 1;
						pq.add(new Node(nn, dist[nn]));
					}
				}
			}
			
			int maxNum = 0;
			int maxIdx = 0;
			
			for (int i = 1; i <= 100; i++) {
				if (dist[i] >= maxNum) {
					maxIdx = i;
					maxNum = dist[i];
				}
			}
			
			System.out.println("#" + tc + " " + maxIdx);
		}
	}
}