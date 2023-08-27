import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 순열을 모두 구하는 프로그램을 작성하시오
 * 조건 : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 순열
 */
public class Backtracking {
	public static void main(String[] args) {
		// 1부터 10까지 중복 없이 2개를 고르는 문제
		backtracking(10, 2, new ArrayList<Integer>());
	}
	
	public static void backtracking(int n, int m, List<Integer> usedList) {
		if (usedList.size() == m) { // m개를 다 고른 경우
			
			// 리스트를 문자열로 합쳐서 출력하는 코드
			StringJoiner sj = new StringJoiner(" ");
			for (int num : usedList) {
				sj.add(String.valueOf(num));
			}
			System.out.println(sj);
			
			return; // return을 통해 메소드 종료
		}
		
		for (int num = 1; num <= n; num++) {
			if (!usedList.contains(num)) { // 사용한 숫자가 아니면
				usedList.add(num); // usedList에 추가
				backtracking(n, m, usedList); // backtracking 재귀 실행
				usedList.remove(usedList.size() - 1); // 메소드가 같은 usedList(힙영역)를 사용하므로 다시 제거해주어야 함
			}
		}
	}
}
