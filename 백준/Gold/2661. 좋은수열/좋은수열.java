import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static String answer = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		calc("");
		System.out.println(answer);
	}
	
	public static void calc(String str) {
		if (answer.length() == N) {
			return;
		}
		
		if (str.length() == N) {
			answer = str;
			return;
		}
		
		p: for (int num = 1; num <= 3; num++) {
			String newStr = str + num;
			
			for (int i = 0; i < newStr.length(); i++) {
				if ((newStr.length() - i) % 2 == 0) {
					String f = newStr.substring(i, i + ((newStr.length() - i) / 2));
					String b = newStr.substring(i + ((newStr.length() - i) / 2), newStr.length());
					
					if (f.equals(b)) {
						continue p;
					}
				}
			}
			
			calc(newStr);
		}
	}
}