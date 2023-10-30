import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		p: for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			Pos[] arr = new Pos[n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}
			
			int[][] dist = new int[n + 2][n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					dist[i][j] = Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y);
				}
			}
			
			Queue<Pos> q = new LinkedList<>();
			boolean[][] isVisit = new boolean[n + 2][n + 2];
			q.add(new Pos(0, 0, 0));
			isVisit[0][0] = true;
			
			while (!q.isEmpty()) {
				Pos c = q.poll();
				
				if (c.n == n + 1) {
					sb.append("happy\n");
					continue p;
				}
				
				for (int i = 0; i < n + 2; i++) {
					if (dist[c.n][i] > 1000) {
						continue;
					}
					
					if (isVisit[c.n][i]) {
						continue;
					}
					
					q.add(arr[i]);
					isVisit[i][c.n] = true;
					isVisit[c.n][i] = true;
				}
			}
			
			sb.append("sad\n");
		}
		
		System.out.print(sb);
	}
}

class Pos {
	int x, y, n;

	public Pos(int x, int y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
}