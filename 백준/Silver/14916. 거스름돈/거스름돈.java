import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= n / 2; i++) {
			int left = n - (i * 2);
			
			if (left % 5 == 0) {
				System.out.println(left / 5 + i);
				return;
			}
		}
		
		System.out.println(-1);
	}
}