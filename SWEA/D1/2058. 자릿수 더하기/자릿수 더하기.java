import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = 0;
		
		for (int i = 0; i < input.length(); i++) {
			num += Integer.parseInt(String.valueOf(input.charAt(i)));
		}
		
		System.out.println(num);
	}
}