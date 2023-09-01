import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
	static int D, W, K, result;
	static int[][] arr;
	static boolean isEnd;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st1.nextToken());
			W = Integer.parseInt(st1.nextToken());
			K = Integer.parseInt(st1.nextToken());
			arr = new int[D][W];
			result = D;
			isEnd = false;
			
			for (int i = 0; i < D; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			for (int i = 0; i < D; i++) {
				int[] pick = new int[i];
				
				if (!isEnd) {
					pick(pick, 0, 0, i);
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	// 바꿀 행 구하는 메소드
	public static void pick(int[] pick, int idx, int cnt, int num) {
		if (cnt == num) {
			int[] convert = new int[D];
			
			if (convert(pick, convert, 0, pick.length)) {
				result = num;
				isEnd = true;
			}
			
			return;
		}
		
		for (int i = idx; i < D; i++) {
			pick[cnt] = i;
			pick(pick, i + 1, cnt + 1, num);
		}
	}
	
	// 해당 행을 0, 1 중 어떤걸로 바꿀지 정하는 메소드
	public static boolean convert(int[] pick, int[] convert, int idx, int n) {
		if (idx == n) {
			if (check(pick, convert)) {
				return true;
			}
			return false;
		}
		
		convert[pick[idx]] = 0;
		if (convert(pick, convert, idx + 1, n)) {
			return true;
		}
		
		convert[pick[idx]] = 1;
		if (convert(pick, convert, idx + 1, n)) {
			return true;
		}
		
		return false;
	}
	
	// 해당하는 조합이 성능테스트를 통과하는지 체크하는 메소드
	public static boolean check(int[] pick, int[] convert) {
		List<Integer> list = Arrays.stream(pick).boxed().collect(Collectors.toList());
		
		p: for (int j = 0; j < W; j++) {
			int cnt = 0;
			int prev = arr[0][j];
			
			if (list.contains(0)) {
				prev = convert[0];
			}
					
			for (int i = 0; i < D; i++) {
				if (list.contains(i)) {
					if (prev == convert[i]) {
						if (++cnt >= K) continue p;
					} else {
						cnt = 1;
						prev = convert[i];
					}
				} else {
					if (prev == arr[i][j]) {
						if (++cnt >= K) continue p;
					} else {
						cnt = 1;
						prev = arr[i][j];
					}
				}
			}
			
			if (cnt < K) {
				return false;
			}
		}
		
		return true;
	}
}