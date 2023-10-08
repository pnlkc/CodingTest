import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int diff = y - x;
			
			long n = 0;
			int cnt = 1;
			
			while (n < diff) {
				n += 2 * cnt++;
			}
			
			if (diff > n - (2 * (cnt - 1)) + (2 * (cnt - 1)) / 2) {
				sb.append((cnt - 1) * 2).append("\n");
			} else {
				sb.append((cnt - 1) * 2 - 1).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}