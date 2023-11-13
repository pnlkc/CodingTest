import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][][] arr = new boolean[201][201][201];
		List<Integer> list = new ArrayList<>();
		Queue<Data> q = new LinkedList<>();
		arr[0][0][C] = true;
		q.add(new Data(0, 0, C));

		while (!q.isEmpty()) {
			Data c = q.poll();
			if (c.a == 0 && !list.contains(c.c)) {
				list.add(c.c);
			}

			// A + B
			if (c.a + c.b > B) {
				if (!arr[c.a + c.b - B][B][c.c]) {
					arr[c.a + c.b - B][B][c.c] = true;
					q.add(new Data(c.a + c.b - B, B, c.c));
				}
			} else if (c.a + c.b <= B) {
				if (!arr[0][c.a + c.b][c.c]) {
					arr[0][c.a + c.b][c.c] = true;
					q.add(new Data(0, c.a + c.b, c.c));
				}
			}

			// A + C
			if (c.a + c.c > C) {
				if (!arr[c.a + c.c - C][c.b][C]) {
					arr[c.a + c.c - C][c.b][C] = true;
					q.add(new Data(c.a + c.c - C, c.b, C));
				}
			} else if (c.a + c.c <= C) {
				if (!arr[0][c.b][c.a + c.c]) {
					arr[0][c.b][c.a + c.c] = true;
					q.add(new Data(0, c.b, c.a + c.c));
				}
			}

			// B + A
			if (c.b + c.a > A) {
				if (!arr[A][c.b + c.a - A][c.c]) {
					arr[A][c.b + c.a - A][c.c] = true;
					q.add(new Data(A, c.b + c.a - A, c.c));
				}
			} else if (c.b + c.a <= A) {
				if (!arr[c.b + c.a][0][c.c]) {
					arr[c.b + c.a][0][c.c] = true;
					q.add(new Data(c.b + c.a, 0, c.c));
				}
			}
			
			// B + C
			if (c.b + c.c > C) {
				if (!arr[c.a][c.b + c.c - C][C]) {
					arr[c.a][c.b + c.c - C][C] = true;
					q.add(new Data(c.a, c.b + c.c - C, C));
				}
			} else if (c.b + c.c <= C) {
				if (!arr[c.a][0][c.b + c.c]) {
					arr[c.a][0][c.b + c.c] = true;
					q.add(new Data(c.a, 0, c.b + c.c));
				}
			}
			
			// C + A
			if (c.c + c.a > A) {
				if (!arr[A][c.b][c.c + c.a - A]) {
					arr[A][c.b][c.c + c.a - A] = true;
					q.add(new Data(A, c.b, c.c + c.a - A));
				}
			} else if (c.c + c.a <= A) {
				if (!arr[c.c + c.a][c.b][0]) {
					arr[c.c + c.a][c.b][0] = true;
					q.add(new Data(c.c + c.a, c.b, 0));
				}
			}
			
			// C + B
			if (c.c + c.b > B) {
				if (!arr[c.a][B][c.c + c.b - B]) {
					arr[c.a][B][c.c + c.b - B] = true;
					q.add(new Data(c.a, B, c.c + c.b - B));
				}
			} else if (c.c + c.b <= B) {
				if (!arr[c.a][c.c + c.b][0]) {
					arr[c.a][c.c + c.b][0] = true;
					q.add(new Data(c.a, c.c + c.b, 0));
				}
			}
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));

			if (i != list.size() - 1) {
				sb.append(" ");
			}
		}

		System.out.println(sb);
	}
}

class Data {
	int a, b, c;

	public Data(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Data [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}