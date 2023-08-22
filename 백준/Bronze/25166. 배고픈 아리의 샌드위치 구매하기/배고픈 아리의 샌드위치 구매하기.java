import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = 1023;
		
		if (A >= S) {
			System.out.println("No thanks");
		} else {
			String str = Integer.toBinaryString((S - A) & M);
			if (str.equals(Integer.toBinaryString(S - A))) {
				System.out.println("Thanks");
			} else {
				System.out.println("Impossible");
			}
		}
	}
}