import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		p: for (; tc > 0; tc--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			Pos s = new Pos(-1, -1, 0);
			Queue<Pos> fire = new LinkedList<>();
			
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					
					if (map[i][j] == '@') {
						s = new Pos(j, i, 0);
						map[i][j] = '.';
					} else if (map[i][j] == '*') {
						fire.offer(new Pos(j, i, 0));
					}
				}
			}
			
			Queue<Pos> q = new LinkedList<>();
			boolean[][] isVisit = new boolean[h][w];
			q.add(s);
			isVisit[s.y][s.x] = true;
			
			while (!q.isEmpty()) {
				Queue<Pos> tempFire = new LinkedList<>();
				
				while (!fire.isEmpty()) {
					Pos c = fire.poll();
				
					for (int d = 0; d < 4; d++) {
						int nx = c.x + dx[d];
						int ny = c.y + dy[d];
						
						if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
							continue;
						}
						
						if (map[ny][nx] == '.') {
							map[ny][nx] = '*';
							tempFire.offer(new Pos(nx, ny, 0));
						}
					}
				}
				
				fire = tempFire;
				
				Queue<Pos> temp = new LinkedList<>();
				int size = q.size();
				
				for (int i = 0; i < size; i++) {
					Pos c = q.poll();
					
					for (int d = 0; d < 4; d++) {
						int nx = c.x + dx[d];
						int ny = c.y + dy[d];
						
						if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
							sb.append(c.t + 1 + "\n");
							continue p;
						}
						
						if (!isVisit[ny][nx] && map[ny][nx] == '.') {
							temp.offer(new Pos(nx, ny, c.t + 1));
							isVisit[ny][nx] = true;
						}
					}
				}
				
				q = temp;
			}
			
			sb.append("IMPOSSIBLE\n");
		}
		
		System.out.println(sb);
	}
}

class Pos {
	int x, y, t;

	public Pos(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}