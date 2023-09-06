import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int[] a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] b = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] c = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] d = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[][] arr = new int[4][];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			arr[3] = d;
			
			Set<Long> set = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i == j) continue;
					
					long xDiff = arr[i][0] - arr[j][0];
					long yDiff = arr[i][1] - arr[j][1];
					
					set.add(xDiff * xDiff + yDiff * yDiff);
				}
			}
			
			List<Long> list = new ArrayList<>(set);
			Collections.sort(list);
			
			if (list.size() == 2 && (list.get(0) * 2 == list.get(1))) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}