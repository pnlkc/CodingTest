import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Pos>> graph = new ArrayList<>();
		int[][] dist = new int[N + 1][N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			dist[s][e] = d;
			dist[e][s] = d;
			
			graph.get(s).add(new Pos(s, e, d));
			graph.get(e).add(new Pos(e, s, d));
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (k == i || i == j || k == j) {
						continue;
					}
					
					if (dist[i][k] == 0 || dist[k][j] == 0) {
						continue;
					}
					
					if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(dist[a][b] + "\n");
		}
		
		System.out.print(sb);
	}
}

class Pos {
	int s, e, d;

	public Pos(int s, int e, int d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}
}