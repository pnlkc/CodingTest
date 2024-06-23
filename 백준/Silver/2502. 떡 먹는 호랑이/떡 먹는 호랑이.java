import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dpA = new int[31];
		int[] dpB = new int[31];
		
		initDp(dpA, dpB);
		System.out.println(calc(D, K, dpA[D], dpB[D]));
	}
	
	public static void initDp(int[] dpA, int[] dpB) {
		dpA[1] = 1;
		dpB[2] = 1;
		
		for (int i = 3; i <= 30; i++) {
			dpA[i] = dpA[i - 1] + dpA[i - 2];
			dpB[i] = dpB[i - 1] + dpB[i - 2];
		}
	}
	
	public static String calc(int D, int K, int a, int b) {
		int numB = K / b;
		
		while (true) {
			int leftA = K - numB * b;
			
			if (leftA / a > 0 && leftA % a == 0) {
				return (leftA / a) + "\n" + numB;
			}
			
			numB--;
		}
	}
}