import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer> pick;
	static int[][] arr;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			pick = new ArrayList<>();
			min = Integer.MAX_VALUE;
			
			for (int i =0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			pick(N / 2, 0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void pick(int n, int cnt, int idx) {
		if (cnt == n) {
			List<Integer> bL = new ArrayList<>();
			
			for (int i = 0; i < n * 2; i++) {
				if (!pick.contains(i)) {
					bL.add(i);
				}
			}
			
			int ar = calc(pick);
			int br = calc(bL);
			
			min = Math.min(min, Math.abs(ar - br));
		} else {
			for (int i = idx; i < n + cnt; i++) {
				pick.add(i);
				pick(n, cnt + 1, i + 1);
				pick.remove(cnt);
			}
		}
	}
	
	public static int calc(List<Integer> pick) {
		int sum = 0;
		
		for (int i = 0; i < pick.size(); i++) {
			for (int j = 0; j < pick.size(); j++) {
				if (i == j) continue;
				
				sum += arr[pick.get(i)][pick.get(j)];
			}
		}
		
		return sum;
	}
}