import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		testcase: for (int t = 0; t < tc; t++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());
		
			int[] person = new int[N]; // 손님 배열
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				person[i] = Integer.parseInt(st2.nextToken());
			}
			
			Arrays.sort(person); // 손님 배열 정렬
			
			int ct = 0; // 현재 시간 (마지막 손님이 온 시간과 동일)
			int left_bread = 0; // 남은 빵
			
			for (int pt : person) { // 손님 배열 순회
				/**
				 * 새로운 손님과 마지막 손님이 온 사이에 빵이 만들어 졌는 지 체크하는 부분
				 * pt / N * K => 새로운 손님이 올때까지 만들 수 있는 빵의 수
				 * ct / N * K => 마지막 손님이 왔을 때까지 만들었던 빵의 수
				 * 둘을 빼면 마지막 손님과 새로운 손님 사이에 만든 빵의 수를 알 수 있음
				 */
				left_bread += (pt / M - ct / M) * K;
				
				if (left_bread == 0) { // 손님에게 줄 빵이 없는 경우
					System.out.println("#" + (t+ 1) + " Impossible");
					continue testcase;
				} else { // 손님에게 줄 빵이 있는 경우
					left_bread--; // 빵을 한개 판매
					ct = pt; // 새로운 손님을 마지막에 온 손님으로 변경
				}
			}
			
			// 여기까지 오는 경우 손님에게 줄 빵이 충분했던 것
			System.out.println("#" + (t+ 1) + " Possible");
		}
	}
}