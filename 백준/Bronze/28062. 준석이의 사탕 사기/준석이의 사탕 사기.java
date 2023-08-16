import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int minOdd = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			
			if (num % 2 != 0) {
				minOdd = Math.min(minOdd, num);
			}
		}
		
		if (sum % 2 == 0) {
			System.out.println(sum);
		} else {
			if (sum % 2 != 0 && minOdd == Integer.MAX_VALUE) {
				System.out.println(0);
			} else {
				System.out.println(sum - minOdd);
			}
		}
	}
}