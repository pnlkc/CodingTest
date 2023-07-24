import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(Character.getNumericValue(input.charAt(i)) - 9);
		}
		
	}
}