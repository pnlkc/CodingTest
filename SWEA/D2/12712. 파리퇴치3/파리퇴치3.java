import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			int max = 0;
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st1.nextToken());
			int m = Integer.parseInt(st1.nextToken());
			
			int[][] arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num1 = arr[i][j];
					int num2 = arr[i][j];
					
					// 십자가 모양
					int[] dx1 = { 1, -1, 0, 0 };
					int[] dy1 = { 0, 0, 1, -1 };
					
					for (int l = 1; l < m; l++) {
						for(int k = 0; k < 4; k++) {
							if (i + dy1[k] * l < 0 || i + dy1[k] * l >= n) continue;
							if (j + dx1[k] * l < 0 || j + dx1[k] * l >= n) continue;
							
							num1 += arr[i + dy1[k] * l][j + dx1[k] * l];
						}
					}
					
					
					// x 모양
					int[] dx2 = { -1, -1, 1, 1 };
					int[] dy2 = { 1, -1, -1, 1 };
					
					for (int l = 1; l < m; l++) {
						for(int k = 0; k < 4; k++) {
							if (i + dy2[k] * l < 0 || i + dy2[k] * l >= n) continue;
							if (j + dx2[k] * l < 0 || j + dx2[k] * l >= n) continue;
							
							num2 += arr[i + dy2[k] * l][j + dx2[k] * l];
						}
					}
					
					max = Math.max(max, Math.max(num1, num2));
				}
			}
			
			System.out.println("#" + (t + 1) + " " + max);
		}
	}
}