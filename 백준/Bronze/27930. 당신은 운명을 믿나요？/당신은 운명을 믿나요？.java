import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String k = "KOREA";
		int ki = 0;
		String y = "YONSEI";
		int yi = 0;
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			
			if (c == k.charAt(ki)) {
				if (++ki == k.length()) {
					System.out.println(k);
					return;
				}
			}
			
			if (c == y.charAt(yi)) {
				if (++yi == y.length()) {
					System.out.println(y);
					return;
				}
			}
		}
	}
}