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
		int[] dx = { 1, -1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, -1, 1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };
		
		p: while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			
			char[][][] map = new char[L][R][C];
			Pos s = new Pos(-1, -1, -1, -1);
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
							
					for (int k = 0; k < C; k++) {
						map[i][j][k] = str.charAt(k);
						
						if (map[i][j][k] == 'S') {
							s = new Pos(i, j, k, 0);
						}
					}
				}
				br.readLine();
			}
			
			Queue<Pos> q = new LinkedList<>();
			boolean[][][] isVisit = new boolean[L][R][C];
			q.add(s);
			isVisit[s.l][s.r][s.c] = true;
			
			while(!q.isEmpty()) {
				Pos c = q.poll();
				
				for (int d = 0; d < 6; d++) {
					int nx = c.c + dx[d];
					int ny = c.r + dy[d];
					int nz = c.l + dz[d];
					
					if (nx < 0 || ny < 0 || nz < 0 || nx >= C || ny >= R || nz >= L) {
						continue;
					}
					
					if (isVisit[nz][ny][nx]) {
						continue;
					}
					
					if (map[nz][ny][nx] == '#') {
						continue;
					}
					
					if (map[nz][ny][nx] == 'E') {
						sb.append("Escaped in " + (c.d + 1) + " minute(s).\n");
						continue p;
					}
					
					isVisit[nz][ny][nx] = true;
					q.add(new Pos(nz, ny, nx, c.d + 1));
				}
			}
			
			sb.append("Trapped!\n");
		}
		
		System.out.println(sb);
	}
}

class Pos {
	int l, r, c, d;

	public Pos(int l, int r, int c, int d) {
		this.l = l;
		this.r = r;
		this.c = c;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Pos [l=" + l + ", r=" + r + ", c=" + c + ", d=" + d + "]";
	}
}