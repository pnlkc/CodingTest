import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		int cn = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cn; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st2.nextToken());
			int num = Integer.parseInt(st2.nextToken());
			
			if (gender == 1) {
				for (int j = num - 1; j < n; j += num) {
					if (arr[j] == 0) arr[j] = 1;
					else arr[j] = 0;
				}
			} else {
				for (int j = 0; ; j++) {
					if (num - 1 + j >= n || num - 1 - j < 0) break;
					if (arr[num - 1 + j] != arr[num - 1 - j]) break;
					
					if (arr[num - 1 + j] == 0) {
						arr[num - 1 + j] = 1;
						arr[num - 1 - j] = 1;		
					} else {
						arr[num - 1 + j] = 0;
						arr[num - 1 - j] = 0;	
					}
				}
			}
		}
		
		int count = 0;
		
		for (int i : arr) {
			count++;
			
			if (count == 20) {
				System.out.print(i);
				System.out.println();
				count = 0;
			} else {
				System.out.print(i + " ");
			}
		}
	}
}