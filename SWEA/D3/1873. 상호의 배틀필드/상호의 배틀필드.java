import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		Map<Character, Integer> dirMap = new HashMap<>();
		dirMap.put('^', 0);
		dirMap.put('U', 0);
		dirMap.put('v', 1);
		dirMap.put('D', 1);
		dirMap.put('<', 2);
		dirMap.put('L', 2);
		dirMap.put('>', 3);
		dirMap.put('R', 3);
		Map<Character, Character> commandMap = new HashMap<>();
		commandMap.put('U', '^');
		commandMap.put('D', 'v');
		commandMap.put('L', '<');
		commandMap.put('R', '>');
		
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			int x = 0;
			int y = 0;
			int dir = 0; // 상, 하, 좌, 우
			
			// 지도 초기화
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					
					if (dirMap.get(map[i][j]) != null) {
						dir = dirMap.get(map[i][j]);
						x = j;
						y = i;
					}
				}
			}
			
			// 커맨드 처리
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				int nx = x;
				int ny = y;
				
				if (c == 'S') {
					while (nx + dx[dir] >= 0 && nx + dx[dir] < W && ny + dy[dir] >= 0 && ny + dy[dir] < H) {
						nx += dx[dir];
						ny += dy[dir];
						
						if (map[ny][nx] != '.' && map[ny][nx] != '-') {
							if (map[ny][nx] == '*') {
								map[ny][nx] = '.';
							}

							break;
						}
					}
					
				} else {
					map[y][x] = commandMap.get(c);
					dir = dirMap.get(c);
					nx += dx[dir];
					ny += dy[dir];
					
					if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
						continue;
					}
					
					if (map[ny][nx] != '.') {
						continue;
					}
					
					map[ny][nx] = map[y][x];
					map[y][x] = '.';
					x = nx;
					y = ny;
				}
			}
			
			sb.append("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
