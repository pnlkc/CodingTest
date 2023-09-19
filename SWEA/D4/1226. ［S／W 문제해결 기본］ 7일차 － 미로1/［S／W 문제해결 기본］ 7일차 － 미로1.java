import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
	int x, y;

	public Pos() {
	}
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		p: for (int tc = 1; tc <= 10; tc++) {
			Integer.parseInt(br.readLine());
			int[][] map = new int[16][16];
			boolean[][] isVisit = new boolean[16][16];
			Pos start = new Pos(); 
			
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					
					if (map[i][j] == 2) {
						start = new Pos(j, i);
					}
				}
			}
			
			Queue<Pos> q = new LinkedList<>();
			q.add(start);
			isVisit[start.y][start.x] = true;
			
			while (!q.isEmpty()) {
				Pos c = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = c.x + dx[d];
					int ny = c.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= 16 || ny >= 16) {
						continue;
					}
					if (isVisit[ny][nx]) continue;
					if (map[ny][nx] == 1) continue;
					
					if (map[ny][nx] == 3) {
						System.out.println("#" + tc + " " + 1);
						continue p;
					} else {
						isVisit[ny][nx] = true;
						q.add(new Pos(nx, ny));
					}
				}
			}
			
			System.out.println("#" + tc + " " + 0);
		}
	}
}