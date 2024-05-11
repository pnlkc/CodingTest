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

		Queue<Pos> q = new LinkedList<>();
		boolean[][][] isVisit = new boolean[N + 1][N + 1][2];
		q.add(new Pos(A, B, 0, 0));
		isVisit[A][B][0] = true;

		while (!q.isEmpty()) {
			Pos c = q.poll();

			if (c.A == c.B) {
				System.out.println(c.num);
				return;
			}

			if (c.isATurn == 0) {
				int aL = (c.A - DA) % N;
				if (aL <= 0)
					aL += N;
				int aR = (c.A + DA) % N;
				if (aR == 0)
					aR = N;

				if (!isVisit[aL][c.B][1]) {
					q.add(new Pos(aL, c.B, c.num + 1, 1));
					isVisit[aL][c.B][1] = true;
				}

				if (!isVisit[aR][c.B][1]) {
					q.add(new Pos(aR, c.B, c.num + 1, 1));
					isVisit[aR][c.B][1] = true;
				}
			} else {
				int bL = (c.B - DB) % N;
				if (bL <= 0)
					bL += N;
				int bR = (c.B + DB) % N;
				if (bR == 0)
					bR = N;

				if (!isVisit[c.A][bL][0]) {
					q.add(new Pos(c.A, bL, c.num + 1, 0));
					isVisit[c.A][bL][0] = true;
				}

				if (!isVisit[c.A][bR][0]) {
					q.add(new Pos(c.A, bR, c.num + 1, 0));
					isVisit[c.A][bR][0] = true;
				}
			}

		}

		System.out.println("Evil Galazy");
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