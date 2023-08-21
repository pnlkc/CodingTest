import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[19][19];
	static int[] dx = { 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] != 0) {
					if (check(j, i, map[i][j])) {
						System.out.println(map[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
	
	public static boolean check(int x, int y, int n) {
		p: for (int d = 0; d < 4; d++) {
			if (x + dx[d] * 4 >= 0 && x + dx[d] * 4 < 19 && y + dy[d] * 4 >= 0 && y + dy[d] * 4 < 19) {
				for (int i = 1; i < 5; i++) {
					if (map[y + dy[d] * i][x + dx[d] * i] != n) {
						continue p;
					}
				}
				
				if (x - dx[d] >= 0 && y - dy[d] >= 0 && x - dx[d] < 19 && y - dy[d] < 19) {
					if (map[y - dy[d]][x - dx[d]] == n) {
						continue p;
					}
				}
				
				if (x + dx[d] * 5 >= 0 && y + dy[d] * 5 >= 0 && x + dx[d] * 5 < 19 && y + dy[d] * 5 < 19) {
					if (map[y + dy[d] * 5][x + dx[d] * 5] == n) {
						continue p;
					}
				}
				
				return true;
			}
		}
	
		return false;
	}
}
