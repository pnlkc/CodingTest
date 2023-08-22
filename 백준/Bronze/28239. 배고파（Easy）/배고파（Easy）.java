import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		p: for (int i = 0; i < n; i++) {
			long m = Long.parseLong(br.readLine());
			
			for (int j = 0; j < 64; j++) {
				long a = (long) Math.pow(2, (double) j);
				
				for (int k = j; k < 64; k++) {
					long b = (long) Math.pow(2, (double) k);
					if (a + b == m) {
						sb.append(j + " " + k).append("\n");
						continue p;
					}
				}
			}
		}
		
		System.out.println(sb);
	}
}