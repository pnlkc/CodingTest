import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int NUM = 1_000_000_007;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		System.out.println(fibonacci(N) + " " + cnt);
	}
	
	public static int fibonacci(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		f[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			cnt = (cnt + 1) % NUM;
			f[i] = (f[i - 1] + f[i - 2]) % NUM;
		}
		
		return f[n];
	}
}