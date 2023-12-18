import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dist = new int[N + 1][N + 1];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a][b] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == k || k == j || i == j) {
						continue;
					}
					
					if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
						continue;
					}
					
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}				
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int cnt = N - 1;
			
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				
				if (dist[i][j] != Integer.MAX_VALUE) {
					cnt--;
				}
			}
			
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				
				if (dist[j][i] != Integer.MAX_VALUE) {
					cnt--;
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.print(sb);
	}
}