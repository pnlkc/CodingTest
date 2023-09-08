import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}
}

public class Main {
	static int r, N;
	static int[][] map;
	static int[][] isVisit;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 1, -1 };
	static List<Pos> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisit = new int[N][N];
		int left = 0;
		List<Pos> listW = new ArrayList<>();    
		List<Pos> listB = new ArrayList<>();
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) left++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					if ((i + j) % 2 == 0) {
						listW.add(new Pos(j, i));
					} else {
						listB.add(new Pos(j, i));
					}
				}
			}
		}    
		
		list = listW;
		
		if (list.size() != 0) {
			if (map[list.get(0).y][list.get(0).x] == 1) {
				visit(list.get(0).x, list.get(0).y, 1);
				calc(1, left - 1, 0); 
				visit(list.get(0).x, list.get(0).y, -1);
			}
			
			calc(0, left, 0);
			
			sum += r;
		}
		
		
		r = 0;
		list = listB;
		isVisit = new int[N][N];

		if (list.size() != 0) {
			if (map[list.get(0).y][list.get(0).x] == 1) {
				visit(list.get(0).x, list.get(0).y, 1);
				calc(1, left - 1, 0); 
				visit(list.get(0).x, list.get(0).y, -1);
			}
			
			calc(0, left, 0);
			
			sum += r;
			
		}
	
		System.out.println(sum);
	}

	public static void calc(int cnt, int left, int idx) {
		if (r >= cnt + left) return;
		
		r = Math.max(r, cnt);
		
		if (idx + 1 == list.size()) return;
		
		Pos p = list.get(idx + 1);
		
		if (isVisit[p.y][p.x] == 0) {
			visit(p.x, p.y, 1);
			calc(cnt + 1, left - 1, idx + 1);
			visit(p.x, p.y, -1);
		}
		
		calc(cnt, left, idx + 1);
	}
	
	public static void visit(int x, int y, int num) {
		isVisit[y][x] += num;

		for (int i = 1; i < N; i++) {
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d] * i;
				int ny = y + dy[d] * i;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				isVisit[ny][nx] += num;
			}
		}
	}
}