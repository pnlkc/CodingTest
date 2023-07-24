import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			String input = br.readLine();
			String y = input.substring(0, 4);
			String m = input.substring(4, 6);
			String d = input.substring(6, 8);
			
			switch (Integer.parseInt(m)) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if (Integer.parseInt(d) >= 1 && Integer.parseInt(d) <= 31) {
						System.out.println("#" + t + " " + y + "/" + m + "/" + d);
						continue;
					}
					break;
				case 4: case 6: case 9: case 11:
					if (Integer.parseInt(d) >= 1 && Integer.parseInt(d) <= 30) {
						System.out.println("#" + t + " " + y + "/" + m + "/" + d);
						continue;
					}
					break;
				case 2:
					if (Integer.parseInt(d) >= 1 && Integer.parseInt(d) <= 28) {
						System.out.println("#" + t + " " + y + "/" + m + "/" + d);
						continue;
					}
					break;
				default:
					break;
			}
			
			System.out.println("#" + t + " " + -1);
		}
		
	}
}