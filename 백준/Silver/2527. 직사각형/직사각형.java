import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ax1 = Integer.parseInt(st.nextToken());
			int ay1 = Integer.parseInt(st.nextToken());
			int ax2 = Integer.parseInt(st.nextToken());
			int ay2 = Integer.parseInt(st.nextToken());

			int bx1 = Integer.parseInt(st.nextToken());
			int by1 = Integer.parseInt(st.nextToken());
			int bx2 = Integer.parseInt(st.nextToken());
			int by2 = Integer.parseInt(st.nextToken());

			// d 경우
			if (ax2 < bx1 || ay2 < by1 || bx2 < ax1 || by2 < ay1) {
				System.out.println("d");
			}
			// c 경우
			else if ((ax2 == bx1 && ay2 == by1) || (bx2 == ax1 && by2 == ay1)
					|| (ax2 == bx1 && ay1 == by2) || (bx2 == ax1 && ay2 == by1)) {
				System.out.println("c");
			}
			// b 경우
			else if ((ax2 == bx1 && ay1 <= by1 && ay2 >= by1) || (ax2 == bx1 && by1 <= ay1 && by2 >= ay1)
					|| (bx2 == ax1 && ay1 <= by1 && ay2 >= by1) || (bx2 == ax1 && by1 <= ay1 && by2 >= ay1)
					|| (ay2 == by1 && ax1 <= bx1 && ax2 >= bx1) || (ay2 == by1 && bx1 <= ax1 && bx2 >= ax1)
					|| (by2 == ay1 && ax1 <= bx1 && ax2 >= bx1) || (by2 == ay1 && bx1 <= ax1 && bx2 >= ax1)) {
				System.out.println("b");
			}
			// a 경우
			else {
				System.out.println("a");
			}

		}
	}
}