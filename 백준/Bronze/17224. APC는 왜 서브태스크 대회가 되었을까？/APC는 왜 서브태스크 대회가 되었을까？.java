import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int L = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		int sum = 0;
		int sub1Cnt = 0;
		int sub2Cnt = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int sub1 = Integer.parseInt(st2.nextToken());
			int sub2 = Integer.parseInt(st2.nextToken());
			
			if (L >= sub2) {
				sub2Cnt++;
			} else if (L >= sub1) {
				sub1Cnt++;
			}
		}
		
		sum += Math.min(sub2Cnt, K) * 140;
		K -= Math.min(sub2Cnt, K);
		sum += Math.min(sub1Cnt, K) * 100;
		
		System.out.println(sum);
	}
}