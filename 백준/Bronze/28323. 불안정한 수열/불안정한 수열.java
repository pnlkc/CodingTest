import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int n = N; n >= 1; n--) {
			calc(0, n, N, new ArrayList<>());
		}
		
		System.out.println(max);
	}
	
	public static void calc(int i, int n, int N, List<Integer> used) {
		if (n < max) return;
		
		if (used.size() == n) {
			for (int idx = 0; idx < used.size() - 1; idx++) {
				if ((used.get(idx) + used.get(idx + 1)) % 2 == 0) {
					return;
				}
			}
			
			max = n;
		} else {
			for (int idx = i; idx < N; idx++) {
				used.add(arr[idx]);
				calc(idx + 1, n, N, used);
				used.remove(used.size() - 1);
			}
		}
	}
}