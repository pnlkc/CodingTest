import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, result;
	static int[] pick;
	static char[] cArr = { 'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z' };
	static String[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pick = new int[26];
		arr = new String[N];
		
		pick[0] = 'a';
		pick[1] = 'c';
		pick[2] = 'i';
		pick[3] = 'n';
		pick[4] = 't';
		
		if (K < 5) {
			System.out.println(0);
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		pick(5, 0);
		
		System.out.println(result);
	}
	
	public static void pick(int cnt, int idx) {
		if (idx >= 21 && cnt < K) {
			return;
		}
		
		if (cnt == K) {
			calc();
			return;
		}
		
		pick[cnt] = cArr[idx];
		pick(cnt + 1, idx + 1);
		pick(cnt, idx + 1);
	}
	
	public static void calc() {
		int cnt = 0;
		
		p: for (int i = 0; i < arr.length; i++) {
			for (int j = 4; j < arr[i].length() - 4; j++) {
				boolean contain = false;
				
				for (int k = 0; k < pick.length; k++) {
					if (arr[i].charAt(j) == pick[k]) {
						contain = true;
						break;
					}
				}
				
				if (!contain) {
					continue p;
				}
			}
			
			cnt++;
		}
		
		result = Math.max(result, cnt);
	}
	
}