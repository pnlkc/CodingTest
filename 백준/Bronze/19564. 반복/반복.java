import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 1;
		
		int prev = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) <= prev) {
				cnt++;
			}
			prev = str.charAt(i);
		}
		
		System.out.println(cnt);
	}
}