import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int dp = Integer.parseInt(st1.nextToken());
			int mp = Integer.parseInt(st1.nextToken());
			int tmp = Integer.parseInt(st1.nextToken());
			int yp = Integer.parseInt(st1.nextToken());
			int[] arr = new int[12];
			int[] memo = new int[13];
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
				arr[i] = Math.min(arr[i] * dp, mp);
			}
			
			for (int i = 1; i <= 12; i++) {
				
				if (i - 3 >= 0) {
					memo[i] = Math.min(memo[i - 1] + arr[i - 1], memo[i - 3] + tmp);
				} else {
					memo[i] = memo[i - 1] + arr[i - 1];
				}
			}
			
			sb.append("#" + tc + " " + Math.min(yp, memo[12])).append("\n");
		}
		
		System.out.println(sb);
	}
}