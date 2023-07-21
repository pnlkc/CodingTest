import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		String answer = "";
		
		for (int i = n; i > 0; i--) {
			String r = String.valueOf(n);
			int cnt = 1;
			
			int a = n;
			int b = i;
			
			while (b >= 0) {
				if (b >= 0) {
					r += " " + b;
					cnt++;
				}
				
				int temp = b;
				b = a - b;
				a = temp;
			}
			
			if (max < cnt) max = cnt;
			if (answer.length() < r.length()) answer = r;
		}
		
		System.out.println(max);
		System.out.println(answer);
	}
}