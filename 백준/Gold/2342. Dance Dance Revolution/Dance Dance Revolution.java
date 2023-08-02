import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] arr = new int[5][5]; // 현재 번호에 대한 발 위치
		boolean isFirst = true;

		while (true) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;

			int[][] temp = new int[5][5];

			if (isFirst) {
				temp[n][0] = 2;
				temp[0][n] = 2;
				isFirst = false;
			} else {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (i == j) continue;
						if (arr[i][j] == 0) continue;
						
						if (n != j) {
							// 왼발
							int num1 = (temp[n][j] == 0) ? Integer.MAX_VALUE : temp[n][j];
							if (n == i) {
								if (temp[n][j] != 0 && temp[n][j] > arr[i][j] + 1) {
									temp[n][j] = arr[i][j] + 1;
								} else if(temp[n][j] == 0) {
									temp[n][j] = arr[i][j] + 1;
								}
							} else if (i == 0) {
								temp[n][j] = Math.min(num1, arr[i][j] + 2);
							} else if (n != 0 && Math.abs(i - n) == 2) {
								temp[n][j] = Math.min(num1, arr[i][j] + 4);
							} else {
								temp[n][j] = Math.min(num1, arr[i][j] + 3);
							}
						}
						
						if (i != n) {
							// 오른발
							int num2 = (temp[i][n] == 0) ? Integer.MAX_VALUE : temp[i][n];
							if (n == j) {
								if (temp[i][n] != 0 && temp[i][n] > arr[i][j] + 1) {
									temp[i][n] = arr[i][j] + 1;
								} else if(temp[i][n] == 0) {
									temp[i][n] = arr[i][j] + 1;
								}
							} else if (j == 0) {
								temp[i][n] = Math.min(num2, arr[i][j] + 2);
							} else if (n != 0 && Math.abs(j - n) == 2) {
								temp[i][n] = Math.min(num2, arr[i][j] + 4);
							} else {
								temp[i][n] = Math.min(num2, arr[i][j] + 3);
							}
						}
					}
				}
			}
			
			arr = temp;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == 0) continue;
				min = Math.min(min, arr[i][j]);
			}
		}
		if (min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
	}
}