import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int idx = 0;
		int cnt = 0;
		char[] arr = { 'p', 'P', 'A', 'p' };

		p: while (idx < str.length()) {
			for (int i = 0; i < 4; i++) {
				if (idx + i >= str.length() || str.charAt(idx + i) != arr[i]) {
					idx++;
					continue p;
				}
			}
			idx += 4;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}