import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double h = Integer.parseInt(st.nextToken()) * 5;
			double m = Integer.parseInt(st.nextToken());
			double s = Integer.parseInt(st.nextToken());
			
			double ha = h * 6;
			double ma = m * 6;
			double sa = s * 6;
	
			ma += 6.0 / 360 * sa;
			ha += 30.0 / 360 * ma;
			
			ha %= 360;
			ma %= 360;
			sa %= 360;
			
			double min = Double.MAX_VALUE;
			min = Math.min(min, Math.min(Math.abs(ha - ma), 360.0 - Math.abs(ha - ma)));
			min = Math.min(min, Math.min(Math.abs(ha - sa), 360.0 - Math.abs(ha - sa)));
			min = Math.min(min, Math.min(Math.abs(ma - sa), 360.0 - Math.abs(ma - sa)));
		
			System.out.println(min);
		}
	}
}