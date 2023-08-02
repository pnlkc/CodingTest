import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 목표값 T
		long cnt = 0L;
		
		// 입력값에 따른 배열 생성
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer sta = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sta.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		StringTokenizer stb = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(stb.nextToken());
		}
		
		// 누적합 생성
		int[] preSumA = new int[n + 1];
		for (int i = 0; i < n; i++) {
			preSumA[i + 1] = preSumA[i] + a[i];
		}
		int[] preSumB = new int[m + 1];
		for (int i = 0; i < m; i++) {
			preSumB[i + 1] = preSumB[i] + b[i];
		}
		
		Map<Integer, Long> aList = new HashMap<>();
		Map<Integer, Long> bList = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (aList.get(preSumA[j + 1] - preSumA[i]) == null) {
					aList.put(preSumA[j + 1] - preSumA[i], 1L);
				} else {
					aList.put(preSumA[j + 1] - preSumA[i], aList.get(preSumA[j + 1] - preSumA[i]) + 1L);
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = i; j < m; j++) {
				if (bList.get(preSumB[j + 1] - preSumB[i]) == null) {
					bList.put(preSumB[j + 1] - preSumB[i], 1L);
				} else {
					bList.put(preSumB[j + 1] - preSumB[i], bList.get(preSumB[j + 1] - preSumB[i]) + 1L);
				}
			}
		}
		
		for (int keyA : aList.keySet()) {
			if (bList.get(t - keyA) != null) {
				cnt += aList.get(keyA) * bList.get(t - keyA);
			}
		}
		
		System.out.println(cnt);
	}
}