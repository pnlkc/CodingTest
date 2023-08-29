import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		p: for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				if ((M & 1) != 1) {
					System.out.println("#" + tc + " OFF");
					continue p;
				}
				
				M >>= 1;
			}
			
			System.out.println("#" + tc + " ON");
		}
	}
}