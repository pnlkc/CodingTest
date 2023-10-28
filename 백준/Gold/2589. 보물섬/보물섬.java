import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int X, Y;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		int result = 0;
		
		for (int i = 0; i < Y; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < X; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (map[i][j] == 'L') {
					result = Math.max(result, bfs(new Pos(j, i, 0)));
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static int bfs(Pos pos) {
		boolean[][] isVisit = new boolean[Y][X];
		Queue<Pos> q = new LinkedList<>();
		q.add(pos);
		isVisit[pos.y][pos.x] = true;
		int max = 0;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			max = Math.max(max, c.d);
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
					continue;
				}
				
				if (isVisit[ny][nx]) {
					continue;
				}
				
				if (map[ny][nx] == 'W') {
					continue;
				}
				
				q.add(new Pos(nx, ny, c.d + 1));
				isVisit[ny][nx] = true;
			}
		}
		
		return max;
	}
}

class Pos {
	int x, y, d;

	public Pos(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}