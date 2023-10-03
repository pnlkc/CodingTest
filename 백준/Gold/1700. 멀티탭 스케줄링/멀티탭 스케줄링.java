import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] arr = new int[K];
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st2.nextToken());
			
			arr[i] = num;
			
			if (map.get(num) == null) {
				map.put(num, new PriorityQueue<>());
			}
			
			map.get(num).add(i);
		}
		
		List<Integer> plug = new ArrayList<>();
		int result = 0;
		
		for (int i = 0; i < K; i++) {
			if (plug.size() < N) {
				if (!plug.contains(arr[i])) {
					plug.add(arr[i]);
					map.get(arr[i]).poll();
				} else {
					map.get(arr[i]).poll();
				}
			} else {
				if (plug.contains(arr[i])) {
					map.get(arr[i]).poll();
					continue;
				}
				
				int maxIdx = 0;
				int pick = -1;
				
				for (int j = 0; j < N; j++) {
					PriorityQueue<Integer> pq = map.get(plug.get(j));
					
					if (pq.isEmpty()) {
						maxIdx = Integer.MAX_VALUE;
						pick = j;
						break;
					} else {
						if (pq.peek() > maxIdx) {
							maxIdx = pq.peek();
							pick = j;
						}
					}
				}
				
				result++;
				plug.set(pick, arr[i]);
				map.get(arr[i]).poll();
			}
		}
		
		System.out.println(result);
	}
}