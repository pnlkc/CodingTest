import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String S = br.readLine();
		
		p: for (int i = 0; i < M; i++) {
			String P = br.readLine();
			if (P.length() < S.length()) {
				sb.append("false\n");
			} else {
				for (int j = 0; j < P.length() - S.length(); j++) {
					int idx = 0;
					for (int k = j; k < P.length(); k++) {
						if (P.charAt(k) == S.charAt(idx)) {
							if (++idx == S.length()) {
								sb.append("true\n");
								continue p;
							}
						}
					}
					
				}
				sb.append("false\n");
			}
		}
		
		System.out.println(sb);
	}
}