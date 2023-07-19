import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[5][5];
		
		// 보드 생성
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 커맨드 배열 생성
		int[] command = new int[25];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				command[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 커맨드에 따라 빙고 게임
		p: for (int c = 0; c < 25; c++) {
			for (int i = 0; i < 5; i++) {	
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == command[c]) {
						board[i][j] = -1;
						boolean r = check(board);
						if (r) {
							System.out.println(c + 1);
							break p;
						}
					}
				}
			}
		}
	}
	
	public static boolean check(int[][] board) {
		int bingo = 0;
		
		// 가로
		p: for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				if (board[y][x] != -1) {
					continue p;
				}
			}
			bingo++;
		}
		
		// 세로
		p: for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (board[y][x] != -1) {
					continue p;
				}
			}
			bingo++;
		}
		
		// 대각선
		boolean r1 = true;
		for (int i = 0; i < 5; i++) {
			if (board[i][i] != -1) {
				r1 = false;
				break;
			}
		}
		if (r1) bingo++;
		
		boolean r2 = true;
		for (int i = 0; i < 5; i++) {
			if (board[i][4 - i] != -1) {
				r2 = false;
				break;
			}
		}
		if (r2) bingo++;
		
		if (bingo >= 3) return true; 
		else return false;
	}
}