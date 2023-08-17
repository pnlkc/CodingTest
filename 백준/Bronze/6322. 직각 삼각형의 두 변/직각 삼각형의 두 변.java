import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0)
				break;

			System.out.println("Triangle #" + idx);
			idx++;
			
			double r;
			if (a == -1) {
				r = Math.sqrt(c * c - b * b);
				if (b > c || a == 0 || b == 0 || r == 0) {
					System.out.println("Impossible.");
				} else {
					System.out.println("a = " + String.format("%.3f", r));
				}
			} else if (b == -1) {
				r = Math.sqrt(c * c - a * a);
				if (a > c || a == 0 || b == 0 || r == 0) {
					System.out.println("Impossible.");
				} else {
					System.out.println("b = " + String.format("%.3f", r));
				}
			} else {
				r = Math.sqrt(a * a + b * b);
				if (a == 0 || b == 0 || r == 0) {
					System.out.println("Impossible.");
				} else {
					System.out.println("c = " + String.format("%.3f", r));
				}
			}

			System.out.println();
		}
	}
}