import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st2.nextToken());
		int c = Integer.parseInt(st2.nextToken());
		int d = Integer.parseInt(st2.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
		
		int cnt = 0;
		
		while (true) {
			if (map[r][c] == 0) { // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
				map[r][c] = 2;
				cnt++;
			}
			
			boolean isExist = false; // 청소되지 않은 빈칸이 있는지 확인하는 변수
			
			for (int i = 0; i < 4; i++) { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
				int nx = c + dx[i];
				int ny = r + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				
				if (map[ny][nx] == 0) { // 청소되지 않은 빈칸이 있는 경우
					isExist = true;
					break;
				}
			}
			
			if (!isExist) { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
				int nx = c - dx[d];
				int ny = r - dy[d];
				
				if (map[ny][nx] == 1) { // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
					break;
				} else { // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다
					r = ny;
					c = nx;
				}
			} else { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
				d = (d + 3) % 4;
				int nx = c + dx[d];
				int ny = r + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				
				if (map[ny][nx] == 0) { // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다
					r = ny;
					c = nx;
				}
			}
		}
		
		System.out.println(cnt);
	}
}