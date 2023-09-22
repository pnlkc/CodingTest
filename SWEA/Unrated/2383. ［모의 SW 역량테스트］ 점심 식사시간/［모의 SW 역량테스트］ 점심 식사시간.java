import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class P {
	int x, y;

	public P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class D extends P {
	int t;

	public D(int x, int y, int t) {
		super(x, y);
		this.t = t;
	}
}

public class Solution {
	static int[][] map;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			answer = Integer.MAX_VALUE;
			D d1 = null;
			D d2 = null;
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			ArrayList<P> pL = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						pL.add(new P(j, i));
					} else if (map[i][j] > 1) {
						if (d1 == null) d1 = new D(j, i, map[i][j]);
						else d2 = new D(j, i, map[i][j]);
					}
				}
			}

			for (int i = 0; i <= pL.size() / 2; i++) {
				combination(i, new ArrayList<>(), pL, d1, d2);
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	public static void combination(int n, ArrayList<Integer> used, ArrayList<P> pL, D d1, D d2) {
		if (used.size() == n) {
			ArrayList<Integer> g2 = new ArrayList<>();
			for (int j = 0; j < pL.size(); j++) {
				if (!used.contains(j)) g2.add(j);
			}
			answer = Math.min(answer, calc(pL, g2, used, d1, d2));
			answer = Math.min(answer, calc(pL, used, g2, d1, d2));
		} else {
			for (int j = 0; j < pL.size(); j++) {
				if (used.contains(j)) continue;
				ArrayList<Integer> temp = (ArrayList<Integer>) used.clone();
				temp.add(j);
				combination(n, temp, pL, d1, d2);
			}
		}
	}

	public static int calc(ArrayList<P> pL, ArrayList<Integer> g1, ArrayList<Integer> g2, D d1, D d2) {
		return Math.max(goStair(pL, g1, d1), goStair(pL, g2, d2));
	}

	public static int goStair(ArrayList<P> pL, ArrayList<Integer> g, D d) {
		PriorityQueue<Integer> wait1 = new PriorityQueue<>();

		for (int i = 0; i < g.size(); i++) {
			P p = pL.get(g.get(i));
			wait1.add(Math.abs(p.x - d.x) + Math.abs(p.y - d.y) + 1);
		}

		Queue<Integer> s = new LinkedList<>();
		while (!wait1.isEmpty()) {
			int w = wait1.poll();
			if (!s.isEmpty() && s.peek() < w) s.poll();

			if (s.size() < 3) s.add(w + d.t);
			else s.add(s.poll() + d.t);
		}
		
		int max = 0;

		for (int num : s) {
			max = Math.max(num, max);
		}
		
		return max;
	}
}