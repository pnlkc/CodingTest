import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			int sum = 0;
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			
			// 입력값을 바탕으로 2차원 배열 생성
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
				}
			}
			
			// 변의 길이가 증가하는 절반까지 계산 (ex. 5의 경우 1~3번줄까지)
			for (int i = 0; i <= n / 2; i++) {
				sum += map[i][n / 2];
				for (int j = 1; j <= i; j++) {
					sum += map[i][n / 2 + (j * 1)];
					sum += map[i][n / 2 + (j * -1)];
				}
			}
			
			// 변의 길이가 감소하는 나머지 절반 계산 (ex. 5의 경우 4~5번줄까지)
			for (int i = n / 2; i > 0; i--) {
				sum += map[n - i][n / 2];
				for (int j = i - 1; j > 0; j--) {
					sum += map[n - i][n / 2 + (j * 1)];
					sum += map[n - i][n / 2 + (j * -1)];
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}