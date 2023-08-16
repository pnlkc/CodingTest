import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] clothes = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			clothes[i] = num;
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int U = Integer.parseInt(st2.nextToken());
		int D = Integer.parseInt(st2.nextToken());
		
		for (int i = 0; i < N; i++) {
			int c = clothes[i];
			if (c == 1) {
				if (U > 0) {
					sb.append("U");
					U--;
				} else {
					System.out.println("NO");
					return;
				}
			} else if (c == 2) {
				if (D > 0) {
					sb.append("D");
					D--;
				} else {
					System.out.println("NO");
					return;
				}
			} else {
				if (U > 0) {
					sb.append("U");
					U--;
				} else if (D > 0) {
					sb.append("D");
					D--;
				} else {
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
		System.out.println(sb);
	}
}