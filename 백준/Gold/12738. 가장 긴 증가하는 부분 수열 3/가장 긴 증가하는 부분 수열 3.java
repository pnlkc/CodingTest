import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list.add(arr[0]);
		
		p: for (int i = 1; i < N; i++) {
			if (arr[i] > list.get(list.size() - 1)) {
				list.add(arr[i]);
			} else {
				int s = 0;
				int e = list.size() - 1;
				
				while (s < e) {
					int mid = (s + e) / 2;
					
					if (list.get(mid) == arr[i]) {
						continue p;
					} else if (list.get(mid) > arr[i]) {
						e = mid;
					} else {
						s = mid + 1;
					}
				}
				
				list.set(e, arr[i]);
			}
		}
		
		System.out.println(list.size());
	}
}