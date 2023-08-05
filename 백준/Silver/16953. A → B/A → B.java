import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		calc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	public static void calc(int a, int b, int n) {
		if (n >= min) return;
		
		if (a == b) {
			min = n;
		} else if (a < b) {
			calc(a * 2, b, n + 1);
			if (a < Integer.MAX_VALUE / 10) {				
				calc(Integer.parseInt(String.valueOf(a) + "1"), b, n + 1);
			}
		}
	}
}