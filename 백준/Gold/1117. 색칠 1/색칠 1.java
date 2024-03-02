import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int divider = Integer.min(W - f, f);
		long max = ((long) W) * H;
		long cnt = 0L;

		if (x1 <= divider && divider <= x2) {
			cnt += (divider - x1) * 2;
			cnt += (x2 - divider);
		} else if (divider <= x1) {
			cnt += x2 - x1;
		} else {
			cnt += (x2 - x1) * 2;
		}

		System.out.println(max - (cnt * (c + 1) * (y2 - y1)));
	}
}