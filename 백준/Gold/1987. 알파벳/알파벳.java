import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static int R;
	static int C;
	static char[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, String.valueOf(arr[0][0]));
		
		System.out.println(max);
	}
	
	public static void dfs(int cx, int cy, String s) {
		max = Math.max(max, s.length());
		
		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || nx >= C || ny < 0 || ny >= R)
				continue;

			if (s.contains(String.valueOf(arr[ny][nx])))
				continue;
			
			dfs(nx, ny, s + arr[ny][nx]);
		}
	}
}