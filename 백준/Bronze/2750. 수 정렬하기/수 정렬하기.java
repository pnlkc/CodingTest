import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		quickSort(arr, 0, N - 1);
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int pivot = hoarePartition(arr, l, r);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);
		}
	}
	
	// Hoare-Partition 알고리즘
	// pivot : 제일 왼쪽 값으로 설정
	public static int hoarePartition(int[] arr, int left, int right) {
		int pivot = arr[left]; // pivot : 제일 왼쪽 값으로 설정
		int l = left + 1; // pivot 바로 다음 인덱스를 제일 왼쪽 포인터로 지정
		int r = right; // 제일 오른쪽 인덱스를 제일 오른쪽 포인터로 지정
		
		while (l <= r) { // 왼쪽 포인터와 오른쪽 포인터가 역전되기 전까지 반복
			while (l <= r && arr[l] <= pivot) { // 오른쪽  포인터와 교차 되지 않고, 피벗보다 작거나 같은 수인 경우 왼쪽 포인터를 오른쪽으로 한 칸씩 이동
				l++;
			}
			
			while (arr[r] > pivot) { // 오른쪽 포인터가 가리키는 값이 피벗보다 큰 경우 오른쪽 포인터를 왼쪽으로 한 칸씩 이동
				r--;
			}
			
			if (l < r) { // 왼쪽 포인터와 오른쪽 포인터가 역전되지 않은 경우
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}
		
		int temp = arr[left];
		arr[left] = arr[r];
		arr[r] = temp;
		
		return r;
	}
}