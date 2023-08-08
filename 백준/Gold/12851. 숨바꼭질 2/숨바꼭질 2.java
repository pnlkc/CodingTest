import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int n, d;

	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}

public class Main {
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	calc(N, K);
    	
    	System.out.println(min);
    	System.out.println(cnt);
    }
	
	public static void calc(int N, int K) {
		Queue<Node> queue = new LinkedList<Node>();
		int[] dist = new int[200_000];
		Arrays.fill(dist, Integer.MAX_VALUE);
		queue.add(new Node(N, 0));
		
		while (!queue.isEmpty()) {
			Node cn = queue.poll();
			if (cn.n == K) {
				if (cn.d < min) {
					min = cn.d;
					cnt = 1;
				} else if (cn.d == min) {
					cnt++;
				}
			}
			
			if (cn.n < K && cn.n + 1 <= 100_000 && dist[cn.n + 1] >= cn.d + 1) {
				dist[cn.n + 1] = cn.d + 1;
				queue.add(new Node(cn.n + 1, cn.d + 1));
			}
			
			if (cn.n - 1 >= 0 && dist[cn.n - 1] >= cn.d + 1) {
				dist[cn.n - 1] = cn.d + 1;
				queue.add(new Node(cn.n - 1, cn.d + 1));
			}
			
			if (cn.n < K && cn.n * 2 <= 100_000 && dist[cn.n * 2] >= cn.d + 1) {
				dist[cn.n * 2] = cn.d + 1;
				queue.add(new Node(cn.n * 2, cn.d + 1));
			}
		}
	}
}