import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		Pos g = null;
		Pos t = null;
		Queue<Pos> waters = new LinkedList<>();
		
		// 지도 초기화
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'S') {
					g = new Pos(j, i);
				} else if (map[i][j] == 'D') {
					t = new Pos(j, i);
				} else if (map[i][j] == '*') {
					waters.add(new Pos(j, i));
				}
			}
		}
		
		boolean isPossible = false;
		int time = 0;
		Queue<Pos> gq = new LinkedList<>();
		gq.add(g);
		
		p: while(!gq.isEmpty()) {
			Queue<Pos> tempWaters = new LinkedList<>();
			while (!waters.isEmpty()) {
				Pos water = waters.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = water.x + dx[d];
					int ny = water.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
						continue;
					}
					
					if (map[ny][nx] != '.') {
						continue;
					}

					tempWaters.offer(new Pos(nx, ny));
					map[ny][nx] = '*';
				}
			}
			
			waters = tempWaters;
			
			time++;
			
			Queue<Pos> tempGQ = new LinkedList<>();
			
			while (!gq.isEmpty()) {
				Pos cg = gq.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = cg.x + dx[d];
					int ny = cg.y + dy[d];
					
					if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
						continue;
					}
					
					if (map[ny][nx] == 'D') {
						isPossible = true;
						break p;
					}
					
					if (map[ny][nx] != '.') {
						continue;
					}
					
					tempGQ.offer(new Pos(nx, ny));
					map[ny][nx] = 'S';
				}
			}
			
			gq = tempGQ;
		}
		
		
		if (!isPossible) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(time);
		}
	}
}

class Pos {
	int x, y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}