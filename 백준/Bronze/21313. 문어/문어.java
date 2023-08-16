import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			if (i % 2 == 0) sb.append("1 ");
			else sb.append("2 ");
		}
		
		if (N % 2 == 0) sb.append("2");
		else sb.append("3");
		
		System.out.println(sb);
	}
}