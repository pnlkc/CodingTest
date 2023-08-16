import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		if (N <= 1) {
			System.out.println(N);
			return;
		}
		
		long cnt = 1;
		long num = 1;
		
		while (N > num) {
			num *= 2;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}