import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pos {
	long x, y;

	public Pos(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

class Node implements Comparable<Node> {
	int n;
	long d;

	public Node(int n, long d) {
		this.n = n;
		this.d = d;
	}

	@Override
	public int compareTo(Node o) {
		if (d < o.d) {
			return -1;
		} else if (d > o.d) {
			return 1;
		} else {
			return 0;
		}
	}
}

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Pos[] island = new Pos[N];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(br.readLine());
			List<List<Node>> graph = new ArrayList<>();
			long result = 0;
			
			for (int i = 0; i < N; i++) {
				island[i] = new Pos(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					
					graph.get(i).add(new Node(j, calcDist(island[i], island[j])));
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] isVisit = new boolean[N];
			int cnt = 0;
			pq.addAll(graph.get(0));
			isVisit[0] = true;
			
			while (!pq.isEmpty()) {
				Node c = pq.poll();
				
				if (!isVisit[c.n]) {
					result += c.d;
					isVisit[c.n] = true;
					pq.addAll(graph.get(c.n));
					
					if (++cnt == N - 1) {
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + Math.round(E * result));
		}
	}
	
	public static long calcDist(Pos p1, Pos p2) {
		long xDiff = p1.x - p2.x;
		long yDiff = p1.y - p2.y;
		return xDiff * xDiff + yDiff * yDiff;
	}
}