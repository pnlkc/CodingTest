import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Pos[] arr = new Pos[N];
		int rx = 0;
		int ry = 0;
		double min = Double.MAX_VALUE;;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			rx += arr[i].x;
			ry += arr[i].y;
		}
		
		for (int i = 0; i < N; i++) {
			min = Math.min(min, calc(rx - arr[i].x, ry - arr[i].y, 0, 0));
		}
		
		System.out.println(rx + " " + ry);
		System.out.printf("%.2f\n", min);
	}
	
	public static double calc(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}