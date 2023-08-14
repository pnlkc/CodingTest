import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		p: for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			for (int i = 0; i <= str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					System.out.println("#" + tc + " " + 0);
					continue p;
				}
			}
			
			System.out.println("#" + tc + " " + 1);
		}
	}
}