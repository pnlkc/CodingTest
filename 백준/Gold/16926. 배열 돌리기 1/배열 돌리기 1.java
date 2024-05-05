import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			rotate(map, N, M);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.stream(map[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
	
	static void rotate(int[][] map, int N, int M) {
		int t = 0;
		int b = N - 1;
		int l = 0;
		int r = M - 1;
		
		while (t < b && l < r) {
			int temp = map[t][l];
			
			for (int i = t; i < b; i++) {
				int prev = temp;
				temp = map[i + 1][l];
				map[i + 1][l] = prev;
			}
			
			for (int j = l; j < r; j++) {
				int prev = temp;
				temp = map[b][j + 1];
				map[b][j + 1] = prev;
			}
			
			for (int i = b; i > t; i--) {
				int prev = temp;
				temp = map[i - 1][r];
				map[i - 1][r] = prev;
			}
			
			for (int j = r; j > l; j--) {
				int prev = temp;
				temp = map[t][j -1];
				map[t][j - 1] = prev;
			}
			
			t++;
			b--;
			l++;
			r--;
		}
	}
}