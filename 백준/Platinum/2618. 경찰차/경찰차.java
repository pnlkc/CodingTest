import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N;
	static int W;
	static int[][] dist;
	static Pos[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		dist = new int[W + 1][W + 1];
		arr = new Pos[W + 1];

		for (int i = 1; i <= W; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			arr[i] = new Pos(x, y);
		}

		System.out.println(calcDist(0, 0));
		calcPath(0, 0);
		
		for (int i = 0; i < dist.length; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
	}
	
	public static int calcDist(int p1, int p2) {
		int max = Math.max(p1, p2);

		if (p1 == W || p2 == W) return 0;
		
		if (dist[p1][p2] != 0) return dist[p1][p2];
		
		int d1 = 0;
		if (p1 == 0) {
			d1 = calc(new Pos(0, 0), arr[max + 1]);
		} else {
			d1 = calc(arr[p1], arr[max + 1]);
		}
		
		int d2 = 0;
		if (p2 == 0) {
			d2 = calc(new Pos(N - 1, N - 1), arr[max + 1]);
		} else {
			d2 = calc(arr[p2], arr[max + 1]);
		}
		
		dist[p1][p2] = Math.min(d1 + calcDist(max + 1, p2), d2 + calcDist(p1, max + 1));
		return dist[p1][p2];
	}
	
	public static void calcPath(int p1, int p2) {
		int max = Math.max(p1, p2);

		if (p1 == W || p2 == W) return;
		
		int d1 = 0;
		if (p1 == 0) {
			d1 = calc(new Pos(1, 1), arr[max + 1]);
		} else {
			d1 = calc(arr[p1], arr[max + 1]);
		}
		
		int d2 = 0;
		if (p2 == 0) {
			d2 = calc(new Pos(N - 1, N - 1), arr[max + 1]);
		} else {
			d2 = calc(arr[p2], arr[max + 1]);
		}
		
		if (d1 + dist[max + 1][p2] < d2 + dist[p1][max + 1]) {
			System.out.println(1);
			calcPath(max + 1, p2);
		} else {
			System.out.println(2);
			calcPath(p1, max + 1);
		}
	}

	public static int calc(Pos p1, Pos p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}