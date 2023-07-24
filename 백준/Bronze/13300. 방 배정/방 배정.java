import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		int answer = 0;
		
		int[] man = new int[6];
		int[] woman = new int[6];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int g = Integer.parseInt(st2.nextToken());
			
			if (s == 0) {
				woman[g - 1]++;
			} else {
				man[g - 1]++;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			answer += woman[i] / k;
			if (woman[i] % k != 0) answer++;
			answer += man[i] / k;
			if (man[i] % k != 0) answer++;
		}
		
		System.out.println(answer);
	}
}