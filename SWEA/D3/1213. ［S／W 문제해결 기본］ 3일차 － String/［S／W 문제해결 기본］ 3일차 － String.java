import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			String target = br.readLine();
			String str = br.readLine();
			int cnt = 0;
			
			p: for (int i = 0; i <= str.length() - target.length(); i++) {
				if (str.charAt(i) == target.charAt(0)) {
					for (int j = 0; j < target.length(); j++) {
						if (str.charAt(i + j) != target.charAt(j)) {
							continue p;
						}
					}
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}