import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (next_permutation(arr)) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < N; i++) {
				sb.append(arr[i] + " ");
			}
			
			System.out.println(sb.toString().trim());
		} else {
			System.out.println(-1);
		}
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