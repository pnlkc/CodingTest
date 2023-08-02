import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	double x;
	double y;

	public Pos(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Node {
	int a;
	int b;
	double dist;
	
	public Node(int a, int b, double dist) {
		this.a = a;
		this.b = b;
		this.dist = dist;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Pos[] arr = new Pos[n];
		List<Node>[] graph = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				double r = calc(arr[i].x, arr[i].y, arr[j].x, arr[j].y);
				if (graph[i] == null) {
					graph[i] = new ArrayList<>();
				}
				graph[i].add(new Node(i, j, r));
				if (graph[j] == null) {
					graph[j] = new ArrayList<>();
				}
				graph[j].add(new Node(j, i, r));
			}
		}
		
		Queue<Node> prim = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.dist > o2.dist) return 1;
				else if (o1.dist < o2.dist) return -1;
				else return 0;
			}
		});
		
		prim.addAll(graph[0]);
		boolean[] isVisit = new boolean[n];
		isVisit[0] = true;
		int cnt = 1;
		double result = 0.0;
		
		while (!prim.isEmpty()) {
			Node c = prim.poll();
			if (!isVisit[c.b]) {
				isVisit[c.b] = true;
				prim.addAll(graph[c.b]);
				cnt++;
				result += c.dist;
			}
			if (cnt == n) break;
		}
		
		System.out.println(result);
	}
	
	public static double calc(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}
}