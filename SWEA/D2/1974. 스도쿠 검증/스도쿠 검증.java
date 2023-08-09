import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		p: for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[9][9];
			
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (!check(j, i, map)) {
						System.out.println("#" + tc + " " + 0);
						continue p;
					}
				}
			}
			
			System.out.println("#" + tc + " " + 1);
		}
	}
	
	public static boolean check(int x, int y, int[][] map) {
		int[] rowC = new int[10];
		for (int i = 0; i < 9; i++) {
			if (++rowC[map[y][i]] > 1) return false;
		}
		
		int[] colC = new int[10];
		for (int i = 0; i < 9; i++) {
			if (++colC[map[i][x]] > 1) return false;
		}
		
		int[] squareC = new int[10];
		for (int i = y / 3 * 3; i < y / 3 * 3 + 3; i++) {
			for (int j = x / 3 * 3; j < x / 3 * 3 + 3; j++) {
				if (++squareC[map[i][j]] > 1) return false;
			}
		}
		
		return true;
	}
}