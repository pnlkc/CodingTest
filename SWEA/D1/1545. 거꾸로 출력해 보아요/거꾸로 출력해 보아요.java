import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String answer = String.valueOf(n);
		
		for (int i = n - 1; i >= 0; i--) {
			answer += " " + i;
		}
		
		System.out.println(answer);
	}
}