import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		
		while (true) {
			String str = br.readLine();
			if (str.equals("0 0 0")) break;
			
			StringTokenizer st = new StringTokenizer(str);
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			while (V > P) {
				V -= P;
				sum += L;
			}
			
			sum += Math.min(V, L);
			
			sb.append("Case " + t++ + ": " + sum + "\n");
		}
		
		System.out.println(sb);
	}
}