import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cPos = 'A';
		int diff = 'Z' - 'A' + 1;
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i);
			int sub = Math.abs(c - cPos);
			sum += Math.min(sub, diff - sub);
			cPos = c;
		}
		
		System.out.println(sum);
	}
}