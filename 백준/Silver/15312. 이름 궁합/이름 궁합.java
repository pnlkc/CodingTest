import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int[] arr = new int[A.length() + B.length()];
		int[][] dp = new int[10][10];
		Map<Character, Integer> map = new HashMap<>();
		int[] cnt = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		
		int idx = 0;
		for (char c = 'A'; c <= 'Z'; c++) {
			map.put(c, cnt[idx++]);
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				dp[i][j] = (i + j) % 10;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = map.get(A.charAt(i / 2));
			} else {
				arr[i] = map.get(B.charAt(i / 2));
			}
		}
		
		while (arr.length > 2) {
			int[] temp = new int[arr.length - 1];
			
			for (int i = 0; i < arr.length - 1; i++) {
				temp[i] = dp[arr[i]][arr[i + 1]];
			}
			
			arr = temp;
		}
		
		System.out.println(arr[0] + "" +  arr[1]);
	}
}