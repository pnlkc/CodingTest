import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if (N % M == 0) {
			System.out.println(0);
			return;
		}
		
		N %= M;
		
		int gcd = gcd(N, M);
		
		System.out.println((M / gcd - 1) * gcd);
	}
	
	public static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		
		return gcd(b, a % b);
	}
}