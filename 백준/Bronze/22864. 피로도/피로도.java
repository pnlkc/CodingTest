import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum = 0;
		int tired = 0;
		
		for (int i = 0; i < 24; i++) {
			if (tired + A > M) {
				tired = Math.max(0, tired - C);
			} else {
				tired += A;
				sum += B;
			}
		}
		
		System.out.println(sum);
		
	}
}