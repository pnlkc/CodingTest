import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		List<int[]> dp = new ArrayList<>();
		int sum = 0;
		
		dp.add(new int[] { 1 });
		
		for (int i = 0; i < W + R; i++) {
			dp.add(new int[dp.get(i).length + 1]);
			
			for (int j = 0; j < i + 1; j++) {
				dp.get(i + 1)[j] += dp.get(i)[j];
				dp.get(i + 1)[j + 1] += dp.get(i)[j];
			}
		}
		
		
		for (int i = R - 1; i < R - 1 + W; i++) {
			for (int j = C - 1; j < C + i - R + 1; j++) {
				sum += dp.get(i)[j];
			}
		}
		
		System.out.println(sum);
	}
}