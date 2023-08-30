import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P {
	int x, y;

	public P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int[] pick;
	static int[][] dist;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			P[] arr = new P[N + 2];
			pick = new int[N];
			min = Integer.MAX_VALUE;
			dist = new int[N + 2][N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N + 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[i] = new P(x, y);
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					int xDiff = Math.abs(arr[i].x - arr[j].x);
					int yDiff = Math.abs(arr[i].y - arr[j].y);

					dist[i][j] = xDiff + yDiff;
				}
			}

			pick(N, 0, 0);

			System.out.println("#" + tc + " " + min);
		}
	}

	public static void pick(int N, int depth, int sum) {
		if (sum > min) return;
		
		if (depth == N) {
			min = Math.min(min, sum + dist[pick[N - 1]][1]);
		} else {
			p: for (int i = 2; i < N + 2; i++) {
				for (int j = 0; j < N; j++) {
					if (pick[j] == i) {
						continue p;
					}
				}
				
				int newSum = sum;
				if (depth == 0) {
					newSum += dist[0][i];
				} else {
					newSum += dist[pick[depth - 1]][i];
				}
				
				pick[depth] = i;
				pick(N, depth + 1, newSum);
				pick[depth] = 0;
			}
		}
	}
}