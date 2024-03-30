import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		char[][] map = new char[2][M];
		int result = 0;
		int cnt = 0;
		int[] dy = { -1, 1 };
		
		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '.') cnt++;
			}
		}
		
		for (int i = 0; i < 2; i++) {
			if (map[i][0] == '#') continue;
			
			Queue<Data> q = new LinkedList<>();
			
			q.add(new Data(0, i, 1));
			
			while (!q.isEmpty()) {
				Data c = q.poll();
				
				if (c.x == M - 1) {
					result = Math.max(result, cnt - c.d);
					break;
				}
				
				if (map[c.y][c.x + 1] == '.') {
					q.add(new Data(c.x + 1, c.y, c.d + 1));
				} else {
					for (int d = 0; d < 2; d++) {
						int ny = c.y + dy[d];
						
						if (ny < 0 || ny >= 2) continue;
						
						q.add(new Data(c.x, ny, c.d + 1));
					}
				}
			}
		}
		
		System.out.println(result);
	}
}

class Data {
	int x, y, d;

	public Data(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}