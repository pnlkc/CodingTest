import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[1_001][1_001];
		int[] cnt = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			
			cnt[i] = dx * dy;
			
			for (int j = y; j < y + dy; j++) {
				for (int k = x; k < x + dx; k++) {
					if (map[j][k] != 0) {
						cnt[map[j][k] - 1]--;
						map[j][k] = i + 1;
					} else {
						map[j][k] = i + 1;
					}
				}
			}
		}
		
		for (int num : cnt) {
			System.out.println(num);
		}
	}
}