import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean result = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		calc(map, 0);
		
		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	public static void calc(char[][] map, int cnt) {
		if (result) {
			return;
		}
		
		if (cnt == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'T') {
						boolean r = check(j, i, map);
						
						if (!r) {
							return;
						}
					}
				}
			}
			
			result = true;
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'X') {
						char[][] temp = new char[N][N];
						copy(map, temp);
						temp[i][j] = 'O';
						calc(temp, cnt + 1);
					}
				}
			}
		}
	}
	
	public static void copy(char[][] ori, char[][] dest) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dest[i][j] = ori[i][j];
			}
		}
	}
	
	public static boolean check(int x, int y, char[][] map) {
		for (int i = 1; i < N; i++) {
			if (x - i >= 0) {
				if (map[y][x - i] == 'O') {
					break;
				} else if (map[y][x - i] == 'S') {
					return false;
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
			if (x + i < N) {
				if (map[y][x + i] == 'O') {
					break;
				} else if (map[y][x + i] == 'S') {
					return false;
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
			if (y - i >= 0) {
				if (map[y - i][x] == 'O') {
					break;
				} else if (map[y - i][x] == 'S') {
					return false;
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
			if (y + i < N) {
				if (map[y + i][x] == 'O') {
					break;
				} else if (map[y + i][x] == 'S') {
					return false;
				}
			}
		}
		
		return true;
	}
}