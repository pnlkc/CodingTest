import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N, num;
	static Deque<Integer> pick = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		num = -1;

		// 1개부터 10개까지 가능
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j <= 9; j++) { // 작은 수부터 큰 수로 탐색 해야 됨 
				pick.offerLast(j);
				pick(i, 1, j);
				
				if (num >= N) { // N번째 감소하는 수를 찾은 경우
					return;
				}
				
				if (!pick.isEmpty()) {
					pick.pollLast();					
				}
			}
		}
		
		System.out.println(-1); // N번째 감소하는 수가 없는 경우에만 여기까지 오게 됨
	}
	
	public static void pick(int max, int cnt, int idx) {
		if (num >= N) { // 이미 찾은 경우
			return;
		}
		
		if (max == cnt) {
			if (++num == N) {
				StringBuilder sb = new StringBuilder();
				
				while (!pick.isEmpty()) {
					sb.append(pick.pollFirst());
				}
				
				System.out.println(sb);
			}
			return;
		}
		
		if (idx < 0) {
			return;
		}
		
		for (int i = 0; i < idx; i++) {
			pick.offerLast(i);
			pick(max, cnt + 1, i);
			pick.pollLast();
		}
	}
}