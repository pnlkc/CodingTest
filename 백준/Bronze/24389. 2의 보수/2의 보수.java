import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = (Integer.MAX_VALUE ^ N) + 1;
		String result = Integer.toBinaryString(N ^ M);
		int cnt = 1;
		
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '1') cnt++;
		}
		
		System.out.println(cnt);
	}
}