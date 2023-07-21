import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st1.nextToken());
		int h = Integer.parseInt(st1.nextToken());
		int p = Integer.parseInt(st2.nextToken());
		int q = Integer.parseInt(st2.nextToken());
		int t = Integer.parseInt(br.readLine());
		int xt = t;
		int yt = t;
		
		while (xt - 2 * w >= 0) {
			xt -= 2 * w;
		}

		while (yt - 2 * h >= 0) {
			yt -= 2 * h;
		}
		
		int dx = 1;
		int dy = 1;

		while (0 < xt) {
			int diffX;
			if (dx == 1)
				diffX = w - p;
			else
				diffX = p;

			if (xt - diffX < 0) {
				p += xt * dx;
				xt = 0;
			} else {
				p += diffX * dx;
				xt -= diffX;
			}
			dx *= -1;
		}
		
		
		while (0 < yt) {
			int diffY;
			if (dy == 1)
				diffY = h - q;
			else
				diffY = q;
			
			if (yt - diffY < 0) {
				q += yt * dy;
				yt = 0;
			} else {
				q += diffY * dy;
				yt -= diffY;
			}
			dy *= -1;
		}

		System.out.println(p + " " + q);
	}
}