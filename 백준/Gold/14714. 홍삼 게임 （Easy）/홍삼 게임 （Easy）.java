import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int DA = Integer.parseInt(st.nextToken());
		int DB = Integer.parseInt(st.nextToken());
		int result = Integer.MAX_VALUE;

		Queue<Pos> q = new LinkedList<>();
		int[][][] isVisit = new int[N + 1][N + 1][2];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				for (int k = 0; k < 2; k++) {					
					isVisit[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		q.add(new Pos(A, B, 0, 0));
		isVisit[A][B][0] = 0;
		

		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			if (c.A == c.B) {
				result = Math.min(result, c.num);
			}

			if (c.isATurn == 0) {
				int aL = (c.A - DA) % N;
				if (aL <= 0)
					aL += N;
				int aR = (c.A + DA) % N;
				if (aR == 0) aR = N;

				if (isVisit[aL][c.B][1] > c.num + 1) {
					q.add(new Pos(aL, c.B, c.num + 1, 1));
					isVisit[aL][c.B][1] = c.num + 1;
				}

				if (isVisit[aR][c.B][1] > c.num + 1) {
					q.add(new Pos(aR, c.B, c.num + 1, 1));
					isVisit[aR][c.B][1] = c.num + 1;
				}
			} else {
				int bL = (c.B - DB) % N;
				if (bL <= 0)
					bL += N;
				int bR = (c.B + DB) % N;
				if (bR == 0) bR = N;

				if (isVisit[c.A][bL][0] > c.num + 1) {
					q.add(new Pos(c.A, bL, c.num + 1, 0));
					isVisit[c.A][bL][0] = c.num + 1;
				}
				
				if (isVisit[c.A][bR][0] > c.num + 1) {
					q.add(new Pos(c.A, bR, c.num + 1, 0));
					isVisit[c.A][bR][0] = c.num + 1;
				}
			}

		}

		if (result == Integer.MAX_VALUE) {			
			System.out.println("Evil Galazy");
		} else {
			System.out.println(result);
		}
	}
}

class Pos {
	int A, B, num, isATurn;

	public Pos(int A, int B, int num, int isATurn) {
		this.A = A;
		this.B = B;
		this.num = num;
		this.isATurn = isATurn;
	}
}