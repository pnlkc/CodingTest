import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = "";
		int[][] dist = new int[N + 1][N + 1];
		int min = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i],Integer.MAX_VALUE);
		}
		
		while (!(input = br.readLine()).equals("-1 -1")) {
			String[] s = input.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					if (i == k || j == k || i == j) {
						continue;
					}
					
					if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
						continue;
					}
					
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int tempMin = 0;
			
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				
				tempMin = Math.max(tempMin, dist[i][j]);
			}
			
			if (tempMin < min) {
				min = tempMin;
				list.clear();
				list.add(i);
			} else if (tempMin == min) {
				list.add(i);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(min + " " + list.size());
		System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}