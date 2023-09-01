import java.util.Arrays;

/**
 * Next Permutation : 다음 순열
 * 
 * 다음 순열 찾는 순서 
 * 1. 가장 오른쪽에 있는 낭떠러지(A == B - 1), 꼭대기(B) 찾기 
 * 	  -> 만약 B의 인덱스가 0이라면 마지막 순열이었던 것이므로 false 리턴 
 * 2. [B ~ 끝] 구간에서 가장 오른쪽에 있는 A보다 커지는 수(C) 찾기 
 *    -> 만약 B가 끝이라면 C가 B가 되어, 3번에서 A와 B의 위치가 스왑 됨 
 * 3. A와 C 스왑 
 * 4. [B ~ 끝] 구간 뒤집기
 */
public class NextPermutation {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 }; // 주어진 수열

		do { // 현재 수열 출력하고 시작
			System.out.println(Arrays.toString(arr));
		} while (next_permutation(arr)); // 다음 순열이 있는 경우
	}

	private static boolean next_permutation(int[] arr) {
		// 1.가장 오른쪽에 있는 낭떠러지(B - 1), 꼭대기(B) 찾기
		int B = arr.length - 1; // 끝에서부터 탐색
		
		while (B > 0 && arr[B - 1] >= arr[B]) {
			B--;
		}

		if (B == 0) { // 마지막 순열이었던 경우
			return false; // false 리턴
		}
		
		int A = B - 1;

		
		// 2. [B ~ 끝] 구간에서 가장 오른쪽에 있는 A보다 커지는 수(C) 찾기
		int C = arr.length - 1; // 끝에서부터 탐색

		while (arr[A] >= arr[C]) {
			C--;
		}

		
		// 3. A와 C 스왑
		swap(arr, A, C);

		
		// 4. [B ~ 끝] 구간 뒤집기
		int R = arr.length - 1; // 오른쪽 포인터 (끝부터 시작)
		
		while (B < R) {
			swap(arr, B++, R--);
		}

		return true; // 다음 순열 생성 완료 및 true 리턴
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
