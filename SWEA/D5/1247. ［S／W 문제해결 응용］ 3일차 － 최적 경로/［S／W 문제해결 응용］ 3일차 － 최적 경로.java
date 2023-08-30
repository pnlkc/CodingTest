import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N, min;
	static int[][] map, dist;
	static Pos firm, home;
	static Pos[] pos;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			firm = new Pos(fx, fy);
			home = new Pos(hx, hy);
			
			pos = new Pos[N];
			
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				pos[i] = new Pos(x, y);
			}
			
			// 그래프 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int xDiff = Math.abs(pos[i].x - pos[j].x);
                    int yDiff = Math.abs(pos[i].y - pos[j].y);
					
					map[i][j] = xDiff + yDiff;
				}
			}
			
			for (int i = 0; i < N; i++) {
				dist = new int[(1 << N) - 1][N];
				
				int xDiff = Math.abs(pos[i].x - firm.x);
                int yDiff = Math.abs(pos[i].y - firm.y);
                
				min = Math.min(min, xDiff + yDiff + calc(i, (1 << i)));
			}
			
			System.out.println("#" + tc + " " + min);
		}
	}

	public static int calc(int num, int isVisit) {
		if (isVisit == (1 << N) - 1) {
			int xDiff = Math.abs(pos[num].x - home.x);
            int yDiff = Math.abs(pos[num].y - home.y);
            
			return xDiff + yDiff;
		} else {
			if (dist[isVisit][num] != 0) {
				return dist[isVisit][num];
			}

			for (int next = 0; next < N; next++) {
				if ((isVisit & (1 << next)) == 0 && map[num][next] != 0) {
					int r = calc(next, (isVisit | (1 << next)));
					
					if (dist[isVisit][num] == 0 || dist[isVisit][num] > r + map[num][next]) {
						dist[isVisit][num] = r + map[num][next];
					}
				}
			}
		}
			
		return dist[isVisit][num];	
	}
}