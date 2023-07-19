import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()) + 1;
		int k = Integer.parseInt(br.readLine());
		int x = 1;
		int y = 0;
		int n = 0;
		
		if (c * r < k) {
			System.out.println(0);
			return;
		}
		
		p: while (true) {
			// 상
			r--;
			for (int i = 1; i <= r; i++) {
				y++;
				n++;
				if (n == k) break p;
			}
			
			// 우
			c--;
			for (int i = 1; i <= c; i++) {
				x++;
				n++;
				if (n == k) break p;
				
			}
			
			// 하
			r--;
			for (int i = 1; i <= r; i++) {
				y--;
				n++;
				if (n == k) break p;
			}
			
			// 좌
			c--;
			for (int i = 1; i <= c; i++) {
				x--;
				n++;
				if (n == k) break p;
			}
		}
		
		System.out.println(x + " " + y);
	}
}