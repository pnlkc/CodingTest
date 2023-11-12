import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] canGo = new boolean[N][N];
		int r = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			canGo[a][b] = true;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j || k == i || k == j) {
						continue;
					}
					
					if (canGo[i][k] && canGo[k][j]) {
						canGo[i][j] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				if (canGo[i][j] || canGo[j][i]) {
					cnt++;
				}
			}
			
			if (cnt == N - 1) {
				r++;
			}
		}
		
		System.out.println(r);
	}
}