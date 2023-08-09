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
			int N = Integer.parseInt(br.readLine());
			int[] arr= new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			
			for (int i = 0; i < N - 1; i++) {
				p: for (int j = i + 1; j < N; j++) {
					int num = arr[i] * arr[j];
					if (num > max) {
						String str = String.valueOf(num);
						for (int k = 0; k < str.length() - 1; k++) {
							int a = Integer.parseInt(String.valueOf(str.charAt(k))); 
							int b = Integer.parseInt(String.valueOf(str.charAt(k + 1))); 
							if (a > b) continue p;
						}
						max = num;
					}
				}
			}
			
			sb.append("#" + tc + " " + max).append("\n");
		}
		
		System.out.println(sb);
	}
}