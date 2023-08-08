import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static List<Pos> zeroList, twoList;
	static int max = Integer.MIN_VALUE;
	static int oneCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		map = new int[N][M];
		zeroList = new ArrayList<>();
		twoList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if (map[i][j] == 0) zeroList.add(new Pos(j, i));
				else if (map[i][j] == 2) twoList.add(new Pos(j, i));
			}
		}
		
		oneCnt = N * M - zeroList.size() - twoList.size();
		
		pick(0, 0, new ArrayList<>());
		
		System.out.println(max);
	}
	
	public static void pick(int n, int idx, List<Pos> used) {
		if (n == 3) {
			calc(used);
		} else {
			for (int i = idx; i < zeroList.size(); i++) {
				used.add(zeroList.get(i));
				pick(n + 1, idx + 1, used);
				used.remove(used.size() - 1);
			}
		}
	}
	
	public static void calc(List<Pos> used) {
		Queue<Pos> queue = new LinkedList<>();
		boolean[][] isVisit = new boolean[N][M]; 
		int cnt = twoList.size();
		queue.addAll(twoList);
		for (Pos p : twoList) {
			isVisit[p.y][p.x] = true;
		}
		
		for (Pos p : used) {
			map[p.y][p.x] = 1;
		}
		
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if (isVisit[ny][nx]) continue;
				
				if (map[ny][nx] == 0) {
					queue.add(new Pos(nx, ny));
					isVisit[ny][nx] = true;
					cnt++;
				}
			}
		}
		
		max = Math.max(max, N * M - oneCnt - cnt - 3);
		
		for (Pos p : used) {
			map[p.y][p.x] = 0;
		}
	}
}