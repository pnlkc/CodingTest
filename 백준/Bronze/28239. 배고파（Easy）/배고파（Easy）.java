import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			long m = Long.parseLong(br.readLine());
			String str = Long.toBinaryString(m);
			int cnt = 0;
			int a = -1;
			int b = -1;
			
			for (int j = 0; j < str.length(); j++) {
				if (Integer.parseInt(String.valueOf(str.charAt(str.length() - 1 - j))) == 1) {
					cnt++;
					
					if (cnt == 1) {
						a = j;
					} else {
						b = j;
						break;
					}
				}
			}
			
			if (cnt == 1) {
				System.out.println((a - 1) + " " + (a - 1));
			} else {
				System.out.println(a + " " + b);
			}
		}
	}
}