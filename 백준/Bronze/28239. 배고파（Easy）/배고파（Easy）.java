import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		p: for (int i = 0; i < n; i++) {
			long m = Long.parseLong(br.readLine());
			String str = Long.toBinaryString(m);
			int cnt = 0;
			int a = -1;

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(str.length() - 1 - j) == '1') {
					if (++cnt == 1) {
						a = j;
					} else {
						sb.append(a + " " + j + "\n");
						continue p;
					}
				}
			}

			sb.append((a - 1) + " " + (a - 1) + "\n");
		}

		System.out.println(sb);
	}
}