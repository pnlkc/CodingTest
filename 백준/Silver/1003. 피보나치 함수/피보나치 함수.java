import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Map<Integer, int[]> dp = new HashMap<>();
		dp.put(0, new int[] { 1, 0 });
		dp.put(1, new int[] { 0, 1 });
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] r = fibonacci(N, dp);
			sb.append((r[0] + " " + r[1])).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int[] fibonacci(int n, Map<Integer, int[]> dp) {
		if (dp.get(n) != null) return dp.get(n);
		
		int[] n1 = fibonacci(n - 1, dp);
		int[] n2 = fibonacci(n - 2, dp);
		
		dp.put(n, new int[] { n1[0] + n2[0], n1[1] + n2[1] });
		return dp.get(n);
	}
}