import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		selectionSort(0, arr);
		
		System.out.println(arr[N / 2]);
	}
	
	public static void selectionSort(int idx, int[] arr) {
		if (idx == arr.length - 1) {
			return;
		} else {
			int minIdx = idx;
			for (int i = idx + 1; i < arr.length; i++) {
				if (arr[minIdx] > arr[i]) {
					minIdx = i;
				}
			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[idx];
			arr[idx] = temp;
			
			selectionSort(idx + 1, arr);
		}
	}
}