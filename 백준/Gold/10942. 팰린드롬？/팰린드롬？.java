import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		boolean[][] check = new boolean[n][n];
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			p: for (int j = i; j < n; j++) {
				int mid = (j - i + 1) / 2 - 1;
				if ((j - i + 1) % 2 != 0) mid++;
				
				for (int k = 0; k <= mid; k++) {
					if (arr[i + k] != arr[j - k]) continue p;
				}
				
				check[i][j] = true;
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken()) - 1;
			int e = Integer.parseInt(st2.nextToken()) - 1;
			if (check[s][e]) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}