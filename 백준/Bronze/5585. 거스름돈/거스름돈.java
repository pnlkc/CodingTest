import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = 1000 - Integer.parseInt(br.readLine());
		System.out.println(M / 500 + M % 500 / 100 + M % 100 / 50 + M % 50 / 10 + M % 10 / 5 + M % 5);
	}
}