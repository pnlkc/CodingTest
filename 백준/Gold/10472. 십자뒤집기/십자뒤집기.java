import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	static int[] dx = { 0, 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());

		p: for (int tc = 1; tc <= P; tc++) {
			char[][] map = new char[3][3];
			char[][] dest = new char[3][3];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = '.';
				}
			}
			
			for (int i = 0; i < 3; i++) {
				String input = br.readLine();

				for (int j = 0; j < 3; j++) {
					dest[i][j] = input.charAt(j);
				}
			}

			Queue<Data> q = new LinkedList<>();
			Map<String, Integer> isVisit = new HashMap<>();
			q.add(new Data(0, map));
			isVisit.put(mapToString(map), 0);
			
			while (!q.isEmpty()) {
				Data c = q.poll();
				
				if (isMatch(c.map, dest)) {
					System.out.println(c.cnt);
					continue p;
				}
				
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						char[][] temp = copyMap(c.map);
						
						for (int d = 0; d < 5; d++) {
							int nx = j + dx[d];
							int ny = i + dy[d];
							
							if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) {
								continue;
							}
							
							if (temp[ny][nx] == '*') {
								temp[ny][nx] = '.';
							} else {
								temp[ny][nx] = '*';
							}
						}
						
						if (isVisit.get(mapToString(temp)) == null || isVisit.get(mapToString(temp)) > c.cnt + 1) {
							q.add(new Data(c.cnt + 1, temp));
							isVisit.put(mapToString(temp), c.cnt + 1);
						}
					}
				}
			}
		}
	}

	public static char[][] copyMap(char[][] ori) {
		char[][] temp = new char[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[i][j] = ori[i][j];
			}
		}

		return temp;
	}
	
	public static boolean isMatch(char[][] a, char[][] b) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
	
	public static String mapToString(char[][] map) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(map[i][j]);
			}
		}
		
		return sb.toString();
	}
}

class Data {
	int cnt;
	char[][] map;
	
	public Data(int cnt, char[][] map) {
		this.cnt = cnt;
		this.map = map;
	}
}