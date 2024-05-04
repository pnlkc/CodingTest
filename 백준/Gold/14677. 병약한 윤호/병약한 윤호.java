import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char[] list = { 'B', 'L', 'D' };
		int result = 0;
		Queue<Node> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[N * 3][N * 3];
		
		q.add(new Node(0, input.length() - 1, 0));
		isVisit[0][input.length() - 1] = true;
		
		while (!q.isEmpty()) {
			Node c = q.poll();
			result = Math.max(result, c.n);
			if (result == N * 3) break;
			
			if (c.l > c.r) continue;
			
			if (input.charAt(c.l) == list[c.n % 3]) {
				if (c.l + 1 <= N * 3 - 1 && !isVisit[c.l + 1][c.r]) {
					q.add(new Node(c.l + 1, c.r, c.n + 1));
					isVisit[c.l + 1][c.r] = true;
				}				
			}
			
			if (input.charAt(c.r) == list[c.n % 3]) {
				if (c.r - 1 >= 0 && !isVisit[c.l][c.r - 1]) {
					q.add(new Node(c.l, c.r - 1, c.n + 1));
					isVisit[c.l][c.r - 1] = true;
				}
			}
		}
		
		System.out.println(result);
	}
}

class Node {
	int l, r, n;

	public Node(int l, int r, int n) {
		this.l = l;
		this.r = r;
		this.n = n;
	}
}