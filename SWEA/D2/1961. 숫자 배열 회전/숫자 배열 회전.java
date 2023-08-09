import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#" + tc).append("\n");
			int[][] r1 = rotation(map, N);
			int[][] r2 = rotation(r1, N);
			int[][] r3 = rotation(r2, N);

			for (int i = 0; i < N; i++) {
				printRow(r1, i, N);
				printRow(r2, i, N);
				printRow(r3, i, N);
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
	
	public static void printRow(int[][] map, int i, int N) {
		for (int j = 0; j < N; j++) {
			sb.append(map[i][j]);
		}
		sb.append(" ");
	}

	public static int[][] rotation(int[][] map, int N) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[j][N - 1 - i] = map[i][j];
			}
		}
		return temp;
	}
}