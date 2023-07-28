import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		calc(map, new int[] { 5, 5, 5, 5, 5 }, 0, 25);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static void calc(int[][] map, int[] remains, int y, int rSum) {
		if (rSum == 0) return;

		for (int i = y; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 0)
					continue;

				for (int k = 5; k > 0; k--) {
					if (remains[k - 1] == 0) continue;
					
					int[][] tM = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);	
					
					if (check(tM, j, i, k)) {
						remains[k - 1]--;
						calc(tM, remains, i, rSum - 1);
						remains[k - 1]++;
					}
				}
				
				return;
			}
		}
		
		min = Math.min(min, 25 - rSum);
	}

	public static boolean check(int[][] map, int x, int y, int n) {
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (i < 0 || i >= map.length || j < 0 || j >= map.length)
					return false;
				if (map[i][j] == 0)
					return false;
				map[i][j] = 0;
			}
		}
		return true;
	}
}