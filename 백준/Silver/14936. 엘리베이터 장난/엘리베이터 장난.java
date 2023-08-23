import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int a = N; // 모두 켜기
		int b = N / 2; // 홀수
		if (N % 2 != 0) b++;
		int c = N / 2; // 짝수
		int d = (N - 1) / 3 + 1; // 3k + 1

		cnt++; // 아무것도 안 누름
		if (a <= m) cnt++;
		if (b <= m && N >= 2) cnt++;
		if (c <= m && N >= 2) cnt++;
		if (d <= m && N >= 3) cnt++;
		if (a + d <= m && N >= 3) cnt++;
		if (b + d <= m && N >= 3) cnt++;
		if (c + d <= m && N >= 3) cnt++;
		
		System.out.println(cnt);
	}
}