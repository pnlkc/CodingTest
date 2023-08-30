import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());
			int[] arr = new int[N];
			int cnt = 0;
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
			}

			p: for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						sum += arr[N - 1 - j];
						
						if (sum > K) { // 이미 더 커진 경우 continue
							continue p;
						}
					}
				}
				
				if (sum == K) { // 원하는 수인 경우
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}