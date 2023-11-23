import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int num = arr[arr.length - 1] - arr[arr.length - 2]; 
		
		for (int i = arr.length - 2; i >= 1; i--) {
			num = gcd(num, arr[i] - arr[i - 1]);
		}
		
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				if (sb.length() != 0) {
					sb.append(" ");
				}
				
				sb.append(i);
			}
		}
		
		System.out.println(sb);
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		
		return gcd(b, a % b);
	}
}