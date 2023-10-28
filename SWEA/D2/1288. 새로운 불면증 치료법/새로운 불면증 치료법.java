import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int isSee = 0;
			int N = Integer.parseInt(br.readLine());
			int num = 0;
			
			while (isSee < (1 << 10) - 1) {
				num += N;

				String str = String.valueOf(num);
				
				for (int i = 0; i < str.length(); i++) {
					int c = str.charAt(i) - '0';
					isSee = isSee | (1 << c);
				}	
			}
			
			sb.append("#" + tc + " " + num + "\n");
		}
		
		System.out.println(sb);
	}
}