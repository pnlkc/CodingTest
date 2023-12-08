import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		String start = "";
		String target = "123456780";
		List<List<Integer>> list = new ArrayList<>();
		
		setList(list);
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				start += st.nextToken();
			}
		}
		
		map.put(start, 0);
		
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			String c = q.poll();
			
			if (c.equals(target)) {
				System.out.println(map.get(c));
				return;
			}
			
			int idx = c.indexOf('0');
			
			for (int next : list.get(idx)) {
				char current = c.charAt(next);
				String newStr = c.toString();
				newStr = newStr.replace('0', '9');
				newStr = newStr.replace(current, '0');
				newStr = newStr.replace('9', current);
				
				if (map.get(newStr) == null || map.get(newStr) > map.get(c) + 1) {
					map.put(newStr, map.get(c) + 1);
					q.offer(newStr);
				}
			}
		}
		
		System.out.println(-1);
	}
	
	public static void setList(List<List<Integer>> list) {
		for (int i = 0; i < 9; i++) {
			list.add(new ArrayList<>());
		}
		
		list.get(0).addAll(Arrays.asList(1, 3));
		list.get(1).addAll(Arrays.asList(0, 2, 4));
		list.get(2).addAll(Arrays.asList(1, 5));
		list.get(3).addAll(Arrays.asList(0, 4, 6));
		list.get(4).addAll(Arrays.asList(1, 3, 5, 7));
		list.get(5).addAll(Arrays.asList(2, 4, 8));
		list.get(6).addAll(Arrays.asList(3, 7));
		list.get(7).addAll(Arrays.asList(4, 6, 8));
		list.get(8).addAll(Arrays.asList(5, 7));
	}
}