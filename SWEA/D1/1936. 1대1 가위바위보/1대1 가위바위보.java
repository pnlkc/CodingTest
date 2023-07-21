import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);		
		int b = Integer.parseInt(input[1]);
		
		if (a == 1) {
			if (b == 2) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		} else if (a == 2) {
			if (b == 1) {
				System.out.println("A");
			} else {
				System.out.println("B");
			}
		} else {
			if (b == 1) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		}
	}
}
