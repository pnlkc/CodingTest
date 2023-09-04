import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long num = 0;

		for (int i = 2; i <= N; i++) {
			num += i - 1;
		}

		System.out.println(num);
	}
}