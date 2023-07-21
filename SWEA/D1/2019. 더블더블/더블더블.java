import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 1;
		String answer = "1";
		
		for (int i = 0; i < n; i++) {
			num *= 2;
			answer += " " + num;
		}
		
		System.out.println(answer);
	}
}