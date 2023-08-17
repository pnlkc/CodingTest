import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			int L = Integer.parseInt(br.readLine());
			if (W * W + H * H < L * L) {
				sb.append("NE").append("\n");
			} else {
				sb.append("DA").append("\n");
			}
		}

		System.out.println(sb);
	}
}