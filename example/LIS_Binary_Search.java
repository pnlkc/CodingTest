import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// LIS(Longest Increasing Subsequence) 알고리즘은 가장 긴 증가하는 부분 수열을 찾는 알고리즘입니다
// LIS를 이분 탐색을 통해 푸는 예제입니다
// 시간 복잡도는 O(NlogN)입니다
//
// ex) 백준 12015번 가장 긴 증가하는 부분 수열2, 3
public class LIS_Binary_Search {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>(); // 증가하는 부분 수열을 담을 리스트

		// 배열 초기화
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 시작 값 추가
		list.add(arr[0]);

		p: for (int i = 1; i < N; i++) { // 0번은 추가했으므로 1번부터 시작
			if (arr[i] > list.get(list.size() - 1)) { // 현재 숫자가 이전 숫자보다 큰 경우
				list.add(arr[i]);
			} else { // 현재 숫자가 이전 숫자보다 작거나 같은 경우
				int s = 0;
				int e = list.size() - 1;

				while (s < e) {
					int mid = (s + e) / 2;

					if (list.get(mid) == arr[i]) { // 현재 숫자와 같은 값의 위치를 찾은 경우
						continue p;
					} else if (list.get(mid) > arr[i]) { // 현재 숫자 보다 큰 값의 위치를 찾은 경우
						e = mid;
					} else { // 현재 숫자 보다 작은 값의 위치를 찾은 경우
						s = mid + 1;
					}
				}

				list.set(e, arr[i]); // 해당 위치를 현재 숫자로 변경
			}
		}

		System.out.println(list.size());
	}
}
