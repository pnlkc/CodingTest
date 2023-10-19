import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, Map<Integer, List<Integer>>> dirMap = new HashMap<>();
	static int N, M, min;
	static int cnt = 0;
	static List<Data> list = new ArrayList<>();
	static Map<Integer, List<Integer>> dir = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 0) {
					cnt++;
				} else if (map[i][j] != 6) {
					list.add(new Data(j, i, map[i][j]));
				}
			}
		}
		
		min = cnt;
		
		initDirMap();
		
		calc(0, cnt, map);
		
		System.out.println(min);
	}
	
	// 1: 동, 2: 서, 3: 남, 4: 북
	public static void initDirMap() {
		for (int i = 1; i <= 4; i++) {
			dir.put(i, new ArrayList<>());
		}
		
		dir.get(1).add(1);
		dir.get(1).add(0);
		dir.get(2).add(0);
		dir.get(2).add(1);
		dir.get(3).add(-1);
		dir.get(3).add(0);
		dir.get(4).add(0);
		dir.get(4).add(-1);
		
		for (int i = 1; i <= 5; i++) {
			dirMap.put(i, new HashMap<>());
			
			for (int j = 1; j <= 4; j++) {
				dirMap.get(i).put(j, new ArrayList<>());
			}
		}
		
		dirMap.get(1).get(1).add(1);
		dirMap.get(1).get(2).add(2);
		dirMap.get(1).get(3).add(3);
		dirMap.get(1).get(4).add(4);
		
		dirMap.get(2).get(1).add(1);
		dirMap.get(2).get(1).add(3);
		dirMap.get(2).get(2).add(2);
		dirMap.get(2).get(2).add(4);
		
		dirMap.get(3).get(1).add(1);
		dirMap.get(3).get(1).add(4);
		dirMap.get(3).get(2).add(2);
		dirMap.get(3).get(2).add(1);
		dirMap.get(3).get(3).add(3);
		dirMap.get(3).get(3).add(2);
		dirMap.get(3).get(4).add(4);
		dirMap.get(3).get(4).add(3);
		
		dirMap.get(4).get(1).add(1);
		dirMap.get(4).get(1).add(3);
		dirMap.get(4).get(1).add(4);
		dirMap.get(4).get(2).add(2);
		dirMap.get(4).get(2).add(4);
		dirMap.get(4).get(2).add(1);
		dirMap.get(4).get(3).add(3);
		dirMap.get(4).get(3).add(1);
		dirMap.get(4).get(3).add(2);
		dirMap.get(4).get(4).add(4);
		dirMap.get(4).get(4).add(2);
		dirMap.get(4).get(4).add(3);
		
		dirMap.get(5).get(1).add(1);
		dirMap.get(5).get(1).add(2);
		dirMap.get(5).get(1).add(3);
		dirMap.get(5).get(1).add(4);
	}
	
	public static void calc(int idx, int result, int[][] map) {
		if (idx == list.size()) {
			return;
		}
		
		Data c = list.get(idx);
		
		for (int i = 1; i <= 4; i++) {
			if (dirMap.get(c.num).get(i).isEmpty()) {
				continue;
			}
			
			int[][] temp = new int[N][M];
			copyMap(map, temp);
			int r = result;
			
			for (int l : dirMap.get(c.num).get(i)) {
				for (int j = 1; j <= Math.max(N, M); j++) {
					int nx = c.x + dir.get(l).get(0) * j;
					int ny = c.y + dir.get(l).get(1) * j;
					
					if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
						break;
					}
					
					if (temp[ny][nx] == 6) {
						break;
					}
					
					if (temp[ny][nx] > 0) {
						continue;
					}

					temp[ny][nx] = 7;
					r--;
				}
			}
			
			min = Math.min(min, r);
			
			calc(idx + 1, r, temp);
		}
	}
	
	public static void copyMap(int[][] ori, int[][] dest) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dest[i][j] = ori[i][j];
			}
		}
	}
}

class Data {
	int x, y, num;

	public Data(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}