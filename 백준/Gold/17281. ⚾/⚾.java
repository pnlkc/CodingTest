import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		calc(0, N, new int[9], new boolean[9]);
		
		System.out.println(max);
	}
	
	public static void calc(int n, int N, int[] used, boolean[] isVisit) {
		if (n == 9) {
			int e = 0;
			int o = 0;
			int i = 0;
			int sum = 0;
			boolean g1 = false;
			boolean g2 = false;
			boolean g3 = false;
			while (e < N) {
				int num = arr[e][used[i]];
				if (num == 0) {
					if (++o == 3) {
						e++;
						o = 0;
						g1 = false;
						g2 = false;
						g3 = false;
					}
				} else if (num == 4) {
					sum++;
					if (g1) {
						sum++;
						g1 = false;
					}
					if (g2) {
						sum++;
						g2 = false;
					}
					if (g3) {
						sum++;
						g3 = false;
					}
				} else if (num == 3) {
					if (g1) {
						sum++;
						g1 = false;
					}
					if (g2) {
						sum++;
						g2 = false;
					}
					if (g3) {
						sum++;
						g3 = false;
					}
					g3 = true;
				} else if (num == 2) {
					if (g3) {
						sum++;
						g3 = false;
					}
					if (g2) {
						sum++;
						g2 = false;
					}
					if (g1) {
						g3 = true;
						g1 = false;
					}
					g2 = true;
				} else if (num == 1) {
					if (g3) {
						sum++;
						g3 = false;
					}
					if (g2) {
						g3 = true;
						g2 = false;
					}
					if (g1) {
						g2 = true;
						g1 = false;
					}
					g1 = true;
				}
				i = (i + 1) % 9;
			}
			
			max = Math.max(max, sum);
		} else {
			if (n == 3) {
				used[3] = 0;
				calc(n + 1, N, used, isVisit);
			} else {
				for (int i = 1; i < 9; i++) {
					if (!isVisit[i]) {
						isVisit[i] = true;
						used[n] = i;
						calc(n + 1, N, used, isVisit);
						isVisit[i] = false;
					}
				}
			}
		}
	}
}