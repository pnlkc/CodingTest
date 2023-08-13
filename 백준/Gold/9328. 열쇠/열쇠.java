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
			Queue<Pos> queue = new LinkedList<>(); // bfs 큐
			Queue<Pos> needCheck = new LinkedList<>(); // 키가 있는지 체크해야 할 문을 담는 큐
			Map<Character, Boolean> hasKey = new HashMap<>();
			int cnt = 0;
			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (i == 0 || i == h - 1 || j == 0 || j == w - 1) { // 가장자리인 경우
						isVisit[i][j] = true;
						
						if (Character.isUpperCase(map[i][j])) { // 문인 경우
							needCheck.add(new Pos(j, i));
						} else if (map[i][j] != '*') { // 문, 벽이 아닌 경우
							queue.add(new Pos(j, i));
							if (map[i][j] == '$') { // 문서인 경우
								cnt++;
							} else if (Character.isLowerCase(map[i][j])) { // 열쇠인 경우
								hasKey.put(map[i][j], true);
							}
						}
					}
				}
			}

			// 시작시 가지고 있는 열쇠
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				hasKey.put(str.charAt(i), true);
			}

			while (!queue.isEmpty() || !needCheck.isEmpty()) { // bfs의 큐와 문(대문자) 큐가 모두 빌 때까지
				if (queue.isEmpty()) { // bfs 큐가 비었을 때
					boolean isChange = false; // 열쇠 획득시 변하는 상황이 있는지 확인하기 위한 변수
					Queue<Pos> temp = new LinkedList<>(); // 상황 변화시 bfs 한번 더 수행 후 문을 확인해야 하기 때문에 임시 큐에 저장
					while (!needCheck.isEmpty()) { // 문 전부 탐색
						Pos c = needCheck.poll();

						if (hasKey.get(Character.toLowerCase(map[c.y][c.x])) == null) { // 문에 맞는 키가 없으면 임시 큐에 저장
							temp.add(c);
						} else { // 문에 맞는 키가 생겼으면
							queue.add(c); // bfs 큐에 추가
							isChange = true; // isChange(상황 변화 변수) true로 변경
						}
					}

					if (isChange) { // 상황이 변했으면 임시 큐에 있는 값을 체크 해야할 문 을 담는 큐에 전부 추가
						needCheck.addAll(temp);
					}
				} else { // bfs 큐가 비어있지 않은 경우
					Pos c = queue.poll();

					for (int d = 0; d < 4; d++) { // 4방 탐색
						int nx = c.x + dx[d];
						int ny = c.y + dy[d];

						if (nx < 0 || nx >= w || ny < 0 || ny >= h) // 범위를 벗어나면 continue
							continue;

						if (isVisit[ny][nx] || map[ny][nx] == '*') // 방문했거나 벽이면 continue
							continue;

						isVisit[ny][nx] = true;

						if (Character.isUpperCase(map[ny][nx])) { // 벽인 경우
							if (hasKey.get(Character.toLowerCase(map[ny][nx])) == null) { // 키가 없는 경우
								needCheck.add(new Pos(nx, ny)); // 체크해야 할 문 큐에 추가
							} else { // 키가 있는 경우
								queue.add(new Pos(nx, ny)); // bfs 큐에 추가
							}
						} else { // 문, 벽이 아닌 경우
							queue.add(new Pos(nx, ny));

							if (Character.isLowerCase(map[ny][nx])) { // 키가 바닥에 있는 경우
								hasKey.put(map[ny][nx], true);
							} else if (map[ny][nx] == '$') { // 문서가 있는 칸인 경우
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