import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		int[] arr = { 2, 3, 5, 7 };
		
		for (int i = 0; i < arr.length; i++) {
			calc(arr[i], 1);
		}
		
		System.out.println(sb);
	}
	
	public static void calc(int num, int length) {
		if (length > 1) {
			if (!check(num)) {
				return;
			}
		}
		
		if (length == N) {
			sb.append(num + "\n");
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			int newNum = Integer.parseInt(String.valueOf(num) + i);
			
			calc(newNum, length + 1); 
		}
	}
	
	public static boolean check(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}