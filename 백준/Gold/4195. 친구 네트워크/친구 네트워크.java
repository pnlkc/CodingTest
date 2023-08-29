import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static List<Integer> parent, rank, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int F = Integer.parseInt(br.readLine());
			parent = new ArrayList<>();
			rank = new ArrayList<>();
			cnt = new ArrayList<>();
			Map<String, Integer> map = new HashMap<>();
			int num = 0;
			
			for (int i = 0; i < F; i++) {
				String[] arr = br.readLine().split(" ");
				if (map.get(arr[0]) == null) {
					map.put(arr[0], num);
					parent.add(num++);
					rank.add(0);
					cnt.add(1);
				}
				
				if (map.get(arr[1]) == null) {
					map.put(arr[1], num);
					parent.add(num++);
					rank.add(0);
					cnt.add(1);
				}				
				
				union(map.get(arr[0]), map.get(arr[1]));
				
				sb.append(cnt.get(find(map.get(arr[0])))).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if (p1 == p2) return;
		
		if (rank.get(p1) > rank.get(p2)) {
			parent.set(p2, p1);
			cnt.set(p1, cnt.get(p1) + cnt.get(p2));
		} else if (rank.get(p1) < rank.get(p2)) {
			parent.set(p1, p2);
			cnt.set(p2, cnt.get(p1) + cnt.get(p2));
		} else {
			parent.set(p2, p1);
			rank.set(p1, rank.get(p1) + 1);
			cnt.set(p1, cnt.get(p1) + cnt.get(p2));
		}
	}
	
	public static int find(int n) {
		if (parent.get(n) != n) {
			parent.set(n, find(parent.get(n)));
			return parent.get(n);
		}
		return parent.get(n);
	}
}