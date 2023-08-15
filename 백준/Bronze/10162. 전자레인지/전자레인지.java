import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String r = "";
		int T = Integer.parseInt(br.readLine());
		if (T % 10 != 0) {
			System.out.println(-1);
		} else {
			r += (T / 300) + " ";
			r += (T % 300 / 60) + " ";
			r += (T % 60 / 10);
			System.out.println(r);
		}
	}
}