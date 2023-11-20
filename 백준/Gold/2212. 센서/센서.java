import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new TreeSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken())) ;
		}
		
		
		int[] arr = new int[set.size() - 1];
		Iterator<Integer> iter = set.iterator();
		
		int idx = 0;
		int prev = iter.next();
		while (iter.hasNext()) {
			int num = iter.next();
			arr[idx++] = num - prev;
			prev = num;
		}
		
		Arrays.sort(arr);
		
		int r = 0;
		for (int i = 0; i < arr.length - (K - 1); i++) {
			r += arr[i];
		}
		
		System.out.println(r);
	}
}