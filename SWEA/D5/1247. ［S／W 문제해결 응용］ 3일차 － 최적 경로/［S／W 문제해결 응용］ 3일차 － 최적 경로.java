import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class P {
	int x, y;

	public P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static List<Integer> used;
	static int[][] dist;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			used = new ArrayList<>();
			min = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			P[] arr = new P[N + 2];
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
			
			pick(N);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void pick(int N) {
		if (used.size() == N) {
			int sum = dist[0][used.get(0)];
			
			for (int i = 0; i < N - 1; i++) {
				sum += dist[used.get(i)][used.get(i + 1)];
			}
			
			sum += dist[used.get(N - 1)][1];
			
			min = Math.min(min, sum);
		} else {
			for (int i = 2; i < N + 2; i++) {
				if (!used.contains(i)) {
					used.add(i);
					pick(N);
					used.remove(used.size() - 1);
				}
			}
		}
	}
}
