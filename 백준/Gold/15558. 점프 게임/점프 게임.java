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
		int k = Integer.parseInt(st.nextToken());
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		char[][] arr = new char[2][];
		arr[0] = A;
		arr[1] = B;
		
		Queue<Pos> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[2][N];
		
		q.add(new Pos(0, 0, 0));
		isVisit[0][0] = true;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			if (c.x + 1 >= N || c.x + k >= N) {
				System.out.println(1);
				return;
			}
			
			if (!isVisit[c.y][c.x + 1] && arr[c.y][c.x + 1] != '0') {
				q.add(new Pos(c.x + 1, c.y, c.time + 1));
				isVisit[c.y][c.x + 1] = true;
			}
			
			if (c.x - 1 > c.time && !isVisit[c.y][c.x - 1] && arr[c.y][c.x - 1] != '0') {
				q.add(new Pos(c.x - 1, c.y, c.time + 1));
				isVisit[c.y][c.x - 1] = true;
			}
			
			if (!isVisit[(c.y + 1) % 2][c.x + k] && arr[(c.y + 1) % 2][c.x + k] != '0') {
				q.add(new Pos(c.x + k, (c.y + 1) % 2, c.time + 1));
				isVisit[(c.y + 1) % 2][c.x + k] = true;
			}
		}
		
		System.out.println(0);
		return;
	}
}

class Pos {
	int x, y, time;

	public Pos(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}