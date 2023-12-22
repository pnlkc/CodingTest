import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int result = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (; T > 0; T--) {
			String str = br.readLine();
			int s = 0;
			int e = str.length() - 1;

			result = 2;
			check(s, e, str, false);
			sb.append(result + "\n");
		}

		System.out.print(sb);
	}

	public static void check(int s, int e, String str, boolean pseudo) {
		if (s >= e) {
			if (pseudo) {
				result = Math.min(result, 1);
			} else {
				result = 0;
			}
			
			return;
		}

		if (str.charAt(s) == str.charAt(e)) {
			check(s + 1, e - 1, str, pseudo);
		} else {
			if (!pseudo) {
				if (str.charAt(s + 1) == str.charAt(e)) {
					check(s + 1, e, str, true);
				}
				
				if (str.charAt(s) == str.charAt(e - 1)) {
					check(s, e - 1, str, true);
				}
			}
		}
	}
}