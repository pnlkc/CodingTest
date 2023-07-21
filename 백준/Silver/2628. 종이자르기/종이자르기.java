import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st1.nextToken());
		int y = Integer.parseInt(st1.nextToken());
		int n = Integer.parseInt(br.readLine());
		boolean[] xarr = new boolean[x + 1];
		xarr[x] = true;
		boolean[] yarr = new boolean[y + 1];
		yarr[y] = true;
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st2.nextToken());
			int idx = Integer.parseInt(st2.nextToken());
			
			if (dir == 0) {
				yarr[idx] = true;
			} else {
				xarr[idx] = true;
			}
		}
		
		for (int i = 0; i <= y; i++) {
			if (!yarr[i]) continue;
			int prevY = 0;
			for (int k = i - 1; k >= 0; k--) {
				if (yarr[k]) {
					prevY = k;
					break;
				}
			}
			int yl = i - prevY;
			
			for (int j = 0; j <= x; j++) {
				if (!xarr[j]) continue;
				int prevX = 0;
				for (int k = j - 1; k >= 0; k--) {
					if (xarr[k]) {
						prevX = k;
						break;
					}
				}
				int xl = j - prevX;
	
				max = Math.max(max, xl * yl);
			}
		}
		
		System.out.println(max);
	}
}