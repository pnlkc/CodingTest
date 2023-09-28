import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();
		int[] pArr = new int[P.length()];
		
		int idx = 0;
		for (int i = 1; i < P.length(); i++) {
			while (idx > 0 && P.charAt(i) != P.charAt(idx)) {
				idx = pArr[idx - 1];
			}
			
			if (P.charAt(i) == P.charAt(idx)) {
				pArr[i] = ++idx;
			}
		}
		
		int result = 0;
		List<Integer> list = new ArrayList<>();
		idx = 0;
		for (int i = 0; i < T.length(); i++) {
			while (idx > 0 && P.charAt(idx) != T.charAt(i)) {
				idx = pArr[idx - 1];
			}
			
			if (P.charAt(idx) == T.charAt(i)) {
				if (idx + 1 == P.length()) {
					result++;
					list.add(i + 1 - idx);
					idx = pArr[idx];
				} else {
					idx++;
				}
			}
			
		}
		
		sb.append(result + "\n");
		
		for (Integer i : list) {
			sb.append(i + "\n");
		}
		
		System.out.print(sb);
	}
}