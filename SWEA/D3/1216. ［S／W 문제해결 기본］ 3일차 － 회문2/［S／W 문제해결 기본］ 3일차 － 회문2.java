import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			int max = 1;
			char[][] map = new char[100][100];
			
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					p1: for (int k = 99; k >= i; k--) {
						for (int l = 0; l <= (k - i) / 2; l++) {
							if (map[i + l][j] != map[k - l][j]) continue p1;
						}
						max = Math.max(max, k - i + 1);
					}
					
					p2: for (int k = 99; k >= j; k--) {
						for (int l = 0; l <= (k - j) / 2; l++) {
							if (map[i][j + l] != map[i][k - l]) continue p2;
						}
						max = Math.max(max, k - j + 1);
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}