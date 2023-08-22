import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Shark {
	int s, d, z;

	public Shark(int s, int d, int z) {
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Shark [s=" + s + ", d=" + d + ", z=" + z + "]";
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st1.nextToken());
		int C = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		Shark[][] map = new Shark[R][C];
		int sum = 0;
		Map<Integer, Integer> dirMap = new HashMap<>();
		dirMap.put(1, 2);
		dirMap.put(2, 1);
		dirMap.put(3, 4);
		dirMap.put(4, 3);
		int[] dx = { 0, 0, 0, 1, -1 };
		int[] dy = { 0, -1, 1, 0, 0 };
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st2.nextToken()) - 1;
			int c = Integer.parseInt(st2.nextToken()) - 1;
			int s = Integer.parseInt(st2.nextToken());
			int d = Integer.parseInt(st2.nextToken());
			int z = Integer.parseInt(st2.nextToken());
			Shark shark = new Shark(s, d, z);
			map[r][c] = shark;
		}

		for (int t = 0; t < C; t++) {
			// 낚시
			for (int i = 0; i < R; i++) {
				if (map[i][t] != null) {
					sum += map[i][t].z;
					map[i][t] = null;
					break;
				}
			}
			
			// 상어 이동
			Shark[][] temp = new Shark[R][C];
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != null) {
						Shark c = map[i][j];
						int dir = c.d;
					
						int nx = j;
						int ny = i;
						int cnt = c.s;
						if (dir == 1 || dir == 2) {
							cnt %= (R - 1) * 2;
						} else {
							cnt %= (C - 1) * 2;
						}
						
						for (int k = 0; k < cnt; k++) {
							if ((nx == 0 && dir == 4) || (nx == C - 1 && dir == 3)) {
								dir = dirMap.get(dir);
							}
							nx += dx[dir];
							
							if ((ny == 0 && dir == 1) || (ny == R - 1 && dir == 2)) {
								dir = dirMap.get(dir);
							}
							ny += dy[dir];
						}
						
						if (temp[ny][nx] != null) {
							if (temp[ny][nx].z < c.z) {
								temp[ny][nx] = new Shark(c.s, dir, c.z);
							}
						} else {
							temp[ny][nx] = new Shark(c.s, dir, c.z);
						}
					}
				}
			}
			
			map = temp;
		}
		
		System.out.println(sum);
	}
}