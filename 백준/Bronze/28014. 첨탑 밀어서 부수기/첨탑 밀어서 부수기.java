import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(st.nextToken());
			
			if (prev <= c) {
				cnt++;
			}
			
			prev = c;
		}

		System.out.println(cnt);
	}
}