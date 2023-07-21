import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		String answer = "1";
		
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				answer += " " + i;
			}
		}
		
		System.out.println(answer);
	}
}