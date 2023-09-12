import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st1.nextToken());
		long y1 = Long.parseLong(st1.nextToken());
		long x2 = Long.parseLong(st1.nextToken());
		long y2 = Long.parseLong(st1.nextToken());
		long x3 = Long.parseLong(st2.nextToken());
		long y3 = Long.parseLong(st2.nextToken());
		long x4 = Long.parseLong(st2.nextToken());
		long y4 = Long.parseLong(st2.nextToken());
		
		if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0L && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0L) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long r = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
		if (r < 0) {
			return -1;
		} else if (r > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}