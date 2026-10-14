import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static int charToValue(char c) {
		if (c >= 'A' && c <= 'Z')
			return c - 'A';
		if (c >= 'a' && c <= 'z')
			return c - 'a' + 26;
		if (c >= '0' && c <= '9')
			return c - '0' + 52;
		if (c == '+')
			return 62;
		if (c == '/')
			return 63;
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine().trim();
			sb.append("#" + tc + " ");

			for (int i = 0; i < str.length(); i += 4) {
				int b0 = charToValue(str.charAt(i));
				int b1 = charToValue(str.charAt(i + 1));
				int b2 = charToValue(str.charAt(i + 2));
				int b3 = charToValue(str.charAt(i + 3));

				int buffer = (b0 << 18) | (b1 << 12) | (b2 << 6) | b3;

				sb.append((char) ((buffer >> 16) & 0xFF));
				sb.append((char) ((buffer >> 8) & 0xFF));
				sb.append((char) (buffer & 0xFF));
			}
			
			sb.append("\n");
		}

		System.out.print(sb);
	}
}