import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			max = Math.max(max, num);
		}
		
		System.out.println(sum - max);
	}
}