import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];

		for (int i = 0; i < n; i++) {
			String[] iSplit = br.readLine().split(" ");
			int ix = Integer.parseInt(iSplit[0]);
			int iy = Integer.parseInt(iSplit[1]);

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[iy + j][ix + k] = true;
				}
			}
		}
		
		int[] dx = new int[] { 1, -1, 0, 0 };
		int[] dy = new int[] { 0, 0, 1, -1 };
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j]) {
					for (int k = 0; k < 4; k++) {
						if (!map[i + dy[k]][j + dx[k]]) {
							sum++;
						}
					}
				}
			}
		}

		System.out.println(sum);
	}
}