import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean result = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		calc(S, T);
		
		if (result) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void calc(String S, String T) {
		if (result) {
			return;
		}
		
		if (S.length() == T.length()) {
			if (S.equals(T)) {
				result = true;
			}
			
			return;
		}
		
		char f = T.charAt(0);
		char l = T.charAt(T.length() - 1);
		
		if (f == 'B') {
			String temp = new StringBuilder(T).reverse().toString();
			temp = temp.substring(0, temp.length() - 1);
			calc(S, temp);
		}
		
		if (l == 'A') {
			String temp = new String(T);
			temp = temp.substring(0, temp.length() - 1);
			calc(S, temp);
		}
	}
}