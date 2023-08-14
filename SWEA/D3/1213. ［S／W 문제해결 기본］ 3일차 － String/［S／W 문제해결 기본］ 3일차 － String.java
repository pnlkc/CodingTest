import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			String target = br.readLine();
			String str = br.readLine();
			Map<Character, Integer> map = new HashMap<>();
			int cnt = 0;
			
			for (int i = 0; i < target.length(); i++) {
				map.put(target.charAt(target.length() - 1 - i), i);
			}
			
			int idx = 0;
			
			p: while (idx < str.length()) {
				if (map.get(str.charAt(idx)) == null) {
					idx += target.length();
				} else if (str.charAt(idx) == target.charAt(target.length() - 1)) {
					for (int i = 0; i < target.length(); i++) {
						if (str.charAt(idx - i) != target.charAt(target.length() - 1 - i)) {
							idx += target.length();
							continue p;
						}
					}
					idx += target.length();
					cnt++;
				} else {
					idx += map.get(str.charAt(idx));
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}