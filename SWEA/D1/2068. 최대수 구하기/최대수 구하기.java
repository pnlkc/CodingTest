import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			
			while (st.hasMoreTokens()) {
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}