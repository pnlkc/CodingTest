import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		while (T.length() > S.length()) {
			char last = T.charAt(T.length() - 1);
			T = T.substring(0, T.length() - 1);

			if (last == 'B') {
				StringBuilder sb = new StringBuilder(T).reverse();
				T = sb.toString();
			}
		}
		
		if (S.equals(T)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}