import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		char[] minA = A.toCharArray();
		char[] maxA = A.toCharArray();
		char[] minB = B.toCharArray();
		char[] maxB = B.toCharArray();
		
		
		for (int i = 0; i < A.length(); i++) {
			if (minA[i] == '6') {
				minA[i] = '5';
			}
			
			if (maxA[i] == '5') {
				maxA[i] = '6';
			}
		}
		
		for (int i = 0; i < B.length(); i++) {
			if (minB[i] == '6') {
				minB[i] = '5';
			}
			
			if (maxB[i] == '5') {
				maxB[i] = '6';
			}
		}
		
		int min = Integer.parseInt(String.valueOf(minA)) + Integer.parseInt(String.valueOf(minB));
		int max = Integer.parseInt(String.valueOf(maxA)) + Integer.parseInt(String.valueOf(maxB));
		
		System.out.println(min + " " + max);
	}
}