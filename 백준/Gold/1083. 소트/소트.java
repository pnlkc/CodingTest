import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int S = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		
		while (idx < N && S > 0) {
			int max = 0;
			int maxIdx = idx;
			
			for (int i = idx; i < Math.min(idx + S + 1, N); i++) {		
				if (arr[i] > max) {
					max = arr[i];
					maxIdx = i;
				}
			}
			
			for (int i = maxIdx; i > idx; i--) {
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
			
			S -= maxIdx - idx;
			idx++;
		}
		
		System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}