import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17406번 배열돌리기 4
public class Main {
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		String[] commandList = new String[k];

		for (int i = 0; i < k; i++) {
			commandList[i] = br.readLine();
		}
		
		calc(Arrays.stream(map).map(int[]::clone).toArray(int[][]::new), commandList, new ArrayList<Integer>());
		
		System.out.println(min);
	}
	
	public static void calc(int[][] map, String[] commandList, ArrayList<Integer> used) {
		if (used.size() == commandList.length) {
			for (int i = 0; i < map.length; i++) {
				int sum = 0;
				for (int j = 0; j < map[i].length; j++) {
					sum += map[i][j];
				}
				min = Math.min(sum, min);
			}
		} else {
			for (int i = 0; i < commandList.length; i++) {
				if (!used.contains(i)) {
					used.add(i);
					String[] split = commandList[i].split(" ");
					int r = Integer.parseInt(split[0]) - 1;
					int c = Integer.parseInt(split[1]) - 1;
					int s = Integer.parseInt(split[2]);
					int[][] temp = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
					rotate(temp, r, c, s);
					calc(temp, commandList, used);
					used.remove(used.size() - 1);
				}
			}
		}
	}

	public static void rotate(int[][] map, int r, int c, int s) {
		for (int i = 0; i < s; i++) {
			int temp1 = -1;
			int temp2 = map[r - s + i][c - s + i];

			// 상
			for (int j = i; j < s * 2 - i; j++) {
				temp1 = map[r - s + i][c - s + j + 1];
				map[r - s + i][c - s + j + 1] = temp2;
				temp2 = temp1;
			}

			// 우
			for (int j = i; j < s * 2 - i; j++) {
				temp1 = map[r - s + j + 1][c + s - i];
				map[r - s + j + 1][c + s - i] = temp2;
				temp2 = temp1;
			}

			// 하
			for (int j = i; j < s * 2 - i; j++) {
				temp1 = map[r + s - i][c + s - j - 1];
				map[r + s - i][c + s - j - 1] = temp2;
				temp2 = temp1;
			}

			// 좌
			for (int j = i; j < s * 2 - i; j++) {
				temp1 = map[r + s - j - 1][c - s + i];
				map[r + s - j - 1][c - s + i] = temp2;
				temp2 = temp1;
			}
		}
	}
}