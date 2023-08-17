import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		double block = ((double) H) / N;
		double sum = 0.0;
		
		for (int i = 1; i <= N / 2; i++) {
			sum += 2 * (H - (block * 2 * i));
		}
		
		System.out.printf("%.6f\n", sum);
	}
}