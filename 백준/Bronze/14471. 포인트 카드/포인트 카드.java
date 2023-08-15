import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int max = 0;
		int sum = 0;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());
			int need = N - A;
			if (need < 0) need = 0; 
			
			max = Math.max(max, need);
			sum += need;
		}
		
		System.out.println(sum - max);
	}
}