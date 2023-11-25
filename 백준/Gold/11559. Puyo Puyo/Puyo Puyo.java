import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int combo;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void pop() {
		boolean hasPop = false;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.') {
					if (bfs(new Pos(j, i))) {
						hasPop = true;
					}
				}
			}
		}
		
		if (hasPop) {
			combo++;
			gravity();
		}
	}

	public static boolean bfs(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		char cPuyo = map[p.y][p.x];
		boolean[][] isVisit = new boolean[12][6];
		List<Pos> list = new ArrayList<>();
		q.offer(p);
		list.add(p);
		isVisit[p.y][p.x] = true;
		
		while (!q.isEmpty()) {
			Pos c = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= 6 || ny >= 12) {
					continue;
				}
				
				if (map[ny][nx] == '.' || map[ny][nx] != cPuyo) {
					continue;
				}
				
				if (isVisit[ny][nx]) {
					continue;
				}
			
				isVisit[ny][nx] = true;
				q.offer(new Pos(nx, ny));
				list.add(new Pos(nx, ny));
			}
		}
		
		if (list.size() >= 4) {
			for (int i = 0; i < list.size(); i++) {
				Pos c = list.get(i);
				map[c.y][c.x] = '.';
			}
			
			return true;
		}
		
		return false;
	}

	public static void gravity() {
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.') {
					int idx = i;
					char c = map[i][j];
					
					while (idx + 1 < 12 && map[idx + 1][j] == '.') {
						idx++;
					}
					
					map[i][j] = '.';
					map[idx][j] = c;
				}
			}
		}
		
		pop();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		pop();
		
		System.out.println(combo);
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}