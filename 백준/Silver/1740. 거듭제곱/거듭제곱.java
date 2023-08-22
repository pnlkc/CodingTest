import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		String NStr = Long.toBinaryString(N);
		long r = 0;
		long c = 1;
		
		for (int i = NStr.length() - 1; i >= 0; i--) {
			if (NStr.charAt(i) == '1') {
				r += c;
			}
			c *= 3;
		}
		
		System.out.println(r);
	}
}