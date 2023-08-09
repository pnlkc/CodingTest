import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int Q = Integer.parseInt(st1.nextToken());
			int[] arr = new int[N + 1];
			
			for (int i = 1; i <= Q; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st2.nextToken());
				int r = Integer.parseInt(st2.nextToken());
				
				for (int j = l; j <= r; j++) {
					arr[j] = i;
				}
			}
			
			sb.append("#" + tc);
			for (int i = 1; i <= N; i++) {
				sb.append(" " + arr[i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}