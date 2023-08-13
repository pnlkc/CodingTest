import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			boolean[][] isVisit = new boolean[h][w];
			Queue<Pos> queue = new LinkedList<>();
			Queue<Pos> needCheck = new LinkedList<>();
			Map<Character, Boolean> hasKey = new HashMap<>();
			int cnt = 0;
			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
						isVisit[i][j] = true;
						
						if (Character.isUpperCase(map[i][j])) {
							needCheck.add(new Pos(j, i));
						} else if (map[i][j] != '*') {
							queue.add(new Pos(j, i));
							if (map[i][j] == '$') {
								cnt++;
							} else if (Character.isLowerCase(map[i][j])) {
								hasKey.put(map[i][j], true);
							}
						}
					}
				}
			}

			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				hasKey.put(str.charAt(i), true);
			}

			while (!queue.isEmpty() || !needCheck.isEmpty()) {
				if (queue.isEmpty()) {
					boolean isChange = false;
					Queue<Pos> temp = new LinkedList<>();
					while (!needCheck.isEmpty()) {
						Pos c = needCheck.poll();

						if (hasKey.get(Character.toLowerCase(map[c.y][c.x])) == null) {
							temp.add(c);
						} else {
							queue.add(c);
							isChange = true;
						}
					}

					if (isChange) {
						needCheck.addAll(temp);
					}
				} else {
					Pos c = queue.poll();
//					System.out.printf("c.x : %d / c.y : %d / cnt : %d\n", c.x, c.y, cnt);

					for (int d = 0; d < 4; d++) {
						int nx = c.x + dx[d];
						int ny = c.y + dy[d];

						if (nx < 0 || nx >= w || ny < 0 || ny >= h)
							continue;

						if (isVisit[ny][nx] || map[ny][nx] == '*')
							continue;

						isVisit[ny][nx] = true;

						if (Character.isUpperCase(map[ny][nx])) {
							if (hasKey.get(Character.toLowerCase(map[ny][nx])) == null) {
								needCheck.add(new Pos(nx, ny));
							} else {
								queue.add(new Pos(nx, ny));
							}
						} else {
							queue.add(new Pos(nx, ny));

							if (Character.isLowerCase(map[ny][nx])) {
								hasKey.put(map[ny][nx], true);
							} else if (map[ny][nx] == '$') {
								cnt++;
							}
						}
					}
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}