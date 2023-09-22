import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int dp, mp, tmp, yp; // 1일, 1달, 3달, 1년
	static int min;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			dp = Integer.parseInt(st1.nextToken());
			mp = Integer.parseInt(st1.nextToken());
			tmp = Integer.parseInt(st1.nextToken());
			yp = Integer.parseInt(st1.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			arr = new int[12];
			min = 0;
			
			for (int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
				min += dp * arr[i];
			}
			
			min = Math.min(min, yp);
			
			calc(0, 0);
			
			sb.append("#" + tc + " " + min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void calc(int m, int pee) {
		if (m >= 12) {
			min = Math.min(min, pee);
			return;
		}
		
		if (pee >= min) {
			return;
		}
		
		if (arr[m] != 0) {
			calc(m + 1, pee + arr[m] * dp);
			calc(m + 1, pee + mp);
			calc(m + 3, pee + tmp);
		} else {
			calc(m + 1, pee);
		}
	}
}