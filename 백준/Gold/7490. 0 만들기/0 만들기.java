import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (; T > 0; T--) {
			int N = Integer.parseInt(br.readLine());
			
			calc(N, 1, "1", sb);
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void calc(int N, int cnt, String str, StringBuilder sb) {
		if (cnt == N) {
			int sum = 0;
			int num = 0;
			char prev = '+';
			boolean isAdd = false;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (c == '+') {
					if (prev == '+') {
						sum += num;
					} else if (prev == '-') {
						sum -= num;
					}
					
					num = 0;
					prev = c;
				} else if (c == '-') {
					if (prev == '+') {
						sum += num;
					} else if (prev == '-') {
						sum -= num;
					}
					
					num = 0;
					prev = c;
				} else if (c == ' ') {
					isAdd = true;
				} else {
					if (isAdd) {
						num = num * 10 + (c - '0');
						isAdd = false;
					} else {
						num = c - '0';
					}
				}
			}
			
			if (prev == '+') {
				sum += num;
			} else if (prev == '-') {
				sum -= num;
			}
			
			
			if (sum == 0) {
				sb.append(str + "\n");
			}
			
			return;
		}
		
		calc(N, cnt + 1, str + " " + (cnt + 1), sb);
		calc(N, cnt + 1, str + "+" + (cnt + 1), sb);
		calc(N, cnt + 1, str + "-" + (cnt + 1), sb);
	}
}