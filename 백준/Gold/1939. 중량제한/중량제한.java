import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, s, e;
	static List<List<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		graph = new ArrayList<>();
		int l = Integer.MAX_VALUE;
		int r = 0;
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			
			l = Math.min(l, c);
			r = Math.max(r, c);
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st3.nextToken());
		e = Integer.parseInt(st3.nextToken());
		
		while (l <= r) {
			int mid = (l + r) / 2;
			
			if (bfs(mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		System.out.println(r);
	}
	
	public static boolean bfs(int num) {
		boolean result = false;
		boolean[] isVisit = new boolean[N + 1];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(s, Integer.MAX_VALUE));
		isVisit[s] = true;
		
		while (!q.isEmpty()) {
			Node c = q.poll();
			if (c.n == e && c.d >= num) {
				result = true;
				break;
			}
			
			for (Node n : graph.get(c.n)) {
				if (n.d < num) {
					continue;
				}
				
				if (isVisit[n.n]) {
					continue;
				}
				
				isVisit[n.n] = true;
				q.add(new Node(n.n, Math.min(c.d, n.d)));
			}
		}
		
		return result;
	}
}

class Node {
	int n, d;

	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}