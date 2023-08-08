import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		long sum = 0;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int gcd = gcd(a, b);
			a /= gcd;
			b /= gcd;
			
			long result = b * calc(a, MOD - 2) % MOD;
			sum += result;
			sum %= MOD;
		}
		
		System.out.println(sum);
	}
	
	// 유클리드 호제법
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
	// 모듈러의 역수 + 페르마 소정리 + 분할 정복
	public static long calc(int a, int b) {
		if (b == 1) {
			return a % MOD;
		} else {
			long result = calc(a, b / 2);
			if (b % 2 == 1) return result % MOD * result % MOD * a % MOD;
			else return result % MOD * result % MOD;
		}
	}
}