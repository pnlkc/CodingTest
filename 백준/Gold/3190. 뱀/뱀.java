import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y, i;

	public Pos(int x, int y, int i) {
		this.x = x;
		this.y = y;
		this.i = i;
	}
}

class Command {
	int t;
	String d;
	
	public Command(int t, String d) {
		this.t = t;
		this.d = d;
	}
}

class Dir {
	int t, dir;

	public Dir(int t, int dir) {
		this.t = t;
		this.dir = dir;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N]; // 0 = 빈칸,  1 = 사과
		boolean[][] snake = new boolean[N][N];
		Queue<Pos> snakeQ = new LinkedList<>();
		Queue<Command> command = new LinkedList<>();
		snake[0][0] = true;
		snakeQ.offer(new Pos(0, 0, 0));

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			command.offer(new Command(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Dir dir = new Dir(0, 0); // 0 = 우, 1 = 하, 2 = 좌, 3 = 상
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		List<Dir> dirList = new ArrayList<>();
		dirList.add(dir);
		
		for (int time = 1; time <= 10_000; time++) {
			int snakeSize = snakeQ.size();
			boolean eatApple = false;
			
			for (int n = 0; n < snakeSize; n++) {
				Pos p = snakeQ.poll();
				
				int nx;
				int ny;
				boolean dirChange = false;
			
				if (dirList.size() > p.i + 1 && time - n - 1 == dirList.get(p.i + 1).t) {
					nx = p.x + dx[dirList.get(p.i + 1).dir];
					ny = p.y + dy[dirList.get(p.i + 1).dir];
					dirChange = true;
				} else {
					nx = p.x + dx[dirList.get(p.i).dir];
					ny = p.y + dy[dirList.get(p.i).dir];
				}
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) { // 벽에 부딪힌 경우
					System.out.println(time);
					return;
				}
				
				if (snake[ny][nx]) { // 자기 몸통에 부딪힌 경우
					System.out.println(time);
					return;
				}
				
				if (map[ny][nx] == 1) { // 사과를 먹은 경우
					eatApple = true;
					map[ny][nx] = 0;
				}
				
				snake[ny][nx] = true;	
				snake[p.y][p.x] = false;	
				if (dirChange) {
					snakeQ.offer(new Pos(nx, ny, p.i + 1));
				} else {
					snakeQ.offer(new Pos(nx, ny, p.i));
				}
				
				if (n == snakeSize - 1) {
					if (eatApple) {
						snake[p.y][p.x] = true;
						snakeQ.offer(new Pos(p.x, p.y, p.i));
					}
				}
			}
			
			if (!command.isEmpty() && command.peek().t == time) {
				Command c = command.poll();
				if (c.d.equals("D")) {
					dir = new Dir(c.t, (dir.dir + 1) % 4);
				} else {
					if (dir.dir == 0) {
						dir = new Dir(c.t, 3);
					} else {
						dir = new Dir(c.t, dir.dir - 1);
					}
				}
				dirList.add(dir);
			}
		}
	}
}