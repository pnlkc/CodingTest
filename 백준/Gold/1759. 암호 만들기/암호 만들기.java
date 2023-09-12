import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String a = "aeiou";
	static String[] pick;
	static String[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		pick = new String[L];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		arr = new String[C];
		
		for (int i = 0; i < C; i++) {
			arr[i] = st2.nextToken();
		}
		
		Arrays.sort(arr);
		
		pick(0, 0, 0, 0);
		
		System.out.println(sb);
	}
	
	public static void pick(int idx, int cnt, int aCnt, int bCnt) {
		if (C - idx + cnt < L) return;
		
		if (cnt == L) {
			if (aCnt >= 1 && bCnt >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(pick[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		if (idx == C) return;

		pick[cnt] = arr[idx];
		if (a.contains(arr[idx])) {
			pick(idx + 1, cnt + 1, aCnt + 1, bCnt);
			pick(idx + 1, cnt, aCnt, bCnt);
		} else {
			pick(idx + 1, cnt + 1, aCnt, bCnt + 1);
			pick(idx + 1, cnt, aCnt, bCnt);
		}
	}
}