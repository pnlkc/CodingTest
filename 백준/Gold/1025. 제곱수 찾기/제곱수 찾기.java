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
		int[][] map = new int[N][M];
		int max = -1;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = -8; k < 9; k++) {
					for (int l = -8; l < 9; l++) {
						if (k == 0 && l == 0) {
							continue;
						}
						
						int y = i;
						int x = j;
						
						int num = map[i][j];
						
						while (y + k >= 0 && y + k < N && x + l >= 0 && x + l < M) {
							y += k;
							x += l;
							num *= 10;
							num += map[y][x];
							
							int floor = (int) Math.floor(Math.sqrt(num));
							int ceil = (int) Math.ceil(Math.sqrt(num));
							
							if (floor == ceil && floor * ceil == num) {
								max = Math.max(max, num);
							}
						}
						
						int floor = (int) Math.floor(Math.sqrt(num));
						int ceil = (int) Math.ceil(Math.sqrt(num));
						
						if (floor == ceil && floor * ceil == num) {
							max = Math.max(max, num);
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
}