import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				if (map.get(c) == null) {
					map.put(c, 0);	
				}
				
				map.put(c, map.get(c) + (int)Math.pow(10, str.length() - 1 - j));
			}
		}
		
		List<Character> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (Character c1, Character c2) -> map.get(c2) - map.get(c1));
	
		int num = 9;
		int result = 0;
		
		for (Character c : list) {
			result += map.get(c) * num--;
		}
		
		System.out.println(result);
	}
}