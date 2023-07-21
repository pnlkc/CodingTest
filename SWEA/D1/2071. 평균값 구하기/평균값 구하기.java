import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double sum = 0.0;
			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			double r = sum / 10;
			System.out.println("#" + (t + 1) + " " + String.format("%.0f", r));
		}
	}
}