import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] heap;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc);
			
			int N = Integer.parseInt(br.readLine());
			heap = new int[N + 1]; // 완전 이진 트리이므로 N + 1 크기의 배열 선언
			size = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
			
				if (command == 1) { // 힙에 추가
					int num = Integer.parseInt(st.nextToken());
					push(num);
				} else { // 힙에서 삭제
					System.out.print(" " + pop());
				}
			}
			
			System.out.println();
		}
	}
	
	public static void push(int num) {
		heap[++size] = num;
		
		int cI = size;
		int pI = cI / 2;
		
		while (pI > 0 && heap[pI] < heap[cI]) {
			int temp = heap[pI];
			heap[pI] = heap[cI];
			heap[cI] = temp;
			
			cI = pI;
			pI = cI / 2;
		}
	}
	
	public static int pop() {
		if (size <= 0) {
			return -1;
		} else {
			int r = heap[1];
			
			heap[1] = heap[size];
			heap[size--] = 0;
			
			int pI = 1;
			int cI = pI * 2;
			
			if (cI + 1 <= size && heap[cI] < heap[cI + 1]) {
				cI++;
			}
			
			while (cI <= size && heap[pI] < heap[cI]) {
				int temp = heap[pI];
				heap[pI] = heap[cI];
				heap[cI] = temp;
				
				pI = cI;
				cI = pI * 2;
				
				if (cI + 1 <= size && heap[cI] < heap[cI + 1]) {
					cI++;
				}
			}
			
			return r;
		}
	}
}