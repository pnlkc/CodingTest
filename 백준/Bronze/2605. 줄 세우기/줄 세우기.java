import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = i;
			
			for (int j = 1; j <= num; j++) {
				int temp = arr[idx - 1];
				arr[idx - 1] = arr[idx];
				arr[idx] = temp;
				idx--;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
			if (i != n - 1) System.out.print(" ");
		}
	}
}