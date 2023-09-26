import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000;
	static long[][] fibOne;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		N = Math.max(1, N - 1);
		fibOne = new long[2][2];
		fibOne[0][0] = 1;
		fibOne[0][1] = 1;
		fibOne[1][0] = 1;
		
		System.out.println(fib(N)[0][0]);
	}
	
	public static long[][] fib(long n) {
		if(n == 1L) {
			return fibOne;
		}
		
		long[][] arr = fib(n / 2);
		
		if (n % 2 == 1) {
			return mutiply(fibOne, mutiply(arr, arr));
		} else {
			return mutiply(arr, arr);
		}
	}
	
	public static long[][] mutiply(long[][] a, long[][] b) {
		long[][] arr = new long[2][2];
		
		arr[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD ;
		arr[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD ;
		arr[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD ;
		arr[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD ;
		
		return arr;
	}
}