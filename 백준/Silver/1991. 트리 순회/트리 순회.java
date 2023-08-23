import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char space;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[(int) Math.pow(2.0, N + 1)];
		arr[1] = 'A';
		
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char p = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			
			int idx = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == p) {
					idx = j;
					break;
				}
			}
			
			arr[idx * 2] = l;
			arr[idx * 2 + 1] = r;
		}
		
		preOrder(1, arr);
		System.out.println();
		inOrder(1, arr);
		System.out.println();
		postOrder(1, arr);
	}
	
	public static void preOrder(int i, char[] arr) {
		if (i < arr.length) {
			if (arr[i] != space && arr[i] != '.') {
				System.out.print(arr[i]);
			}
			preOrder(i * 2, arr);
			preOrder(i * 2 + 1, arr);
		}
	}
	
	
	public static void inOrder(int i, char[] arr) {
		if (i < arr.length) {
			inOrder(i * 2, arr);
			if (arr[i] != space && arr[i] != '.') {
				System.out.print(arr[i]);
			}
			inOrder(i * 2 + 1, arr);
		}
	}
	
	public static void postOrder(int i, char[] arr) {
		if (i < arr.length) {
			postOrder(i * 2, arr);
			postOrder(i * 2 + 1, arr);
			if (arr[i] != space && arr[i] != '.') {
				System.out.print(arr[i]);
			}
		}
	}
}