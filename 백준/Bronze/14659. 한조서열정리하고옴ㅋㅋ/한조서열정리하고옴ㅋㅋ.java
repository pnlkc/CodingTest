import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		p: for (int i = 0; i < N; i++) {
			int cnt = 0;
			
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) {
					cnt++;
				} else if (arr[i] < arr[j]) {
					max = Math.max(max, cnt);
					continue p;
				}
			}
			
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}
}