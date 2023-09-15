import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 14499번 주사위 굴리기
public class Main {
	static int[][] dice;
	static int[] dx = { 0, 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int y = Integer.parseInt(st1.nextToken());
		int x = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		int[][] map = new int[N][M];
		dice = new int[4][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		int[] command = new int[K];
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			command[i] = Integer.parseInt(st3.nextToken());
		}
		
		for (int i = 0; i < K; i++) {
			int nx = x + dx[command[i]];
			int ny = y + dy[command[i]];
			
			if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
				continue;
			}
			
			if (command[i] == 1) {
				moveR();
			} else if (command[i] == 2) {
				moveL();
			} else if (command[i] == 3) {
				moveU();
			} else {
				moveD();
			}
			
			if (map[ny][nx] == 0) {
				map[ny][nx] = dice[3][1];
			} else if (map[ny][nx] != 0) {
				dice[3][1] = map[ny][nx];
				map[ny][nx] = 0;
			}
			
			x = nx;
			y = ny;
			
			System.out.println(dice[1][1]);
		}
	}
	
	public static void moveL() {
		int temp = dice[1][1];
		dice[1][1] = dice[1][2];
		dice[1][2] = dice[3][1];
		dice[3][1] = dice[1][0];
		dice[1][0] = temp;
	}
	
	public static void moveR() {
		int temp = dice[1][1];
		dice[1][1] = dice[1][0];
		dice[1][0] = dice[3][1];
		dice[3][1] = dice[1][2];
		dice[1][2] = temp;
	}
	
	public static void moveU() {
		int temp = dice[1][1];
		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = dice[0][1];
		dice[0][1] = temp;
	}
	
	public static void moveD() {
		int temp = dice[1][1];
		dice[1][1] = dice[0][1];
		dice[0][1] = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = temp;
	}
}