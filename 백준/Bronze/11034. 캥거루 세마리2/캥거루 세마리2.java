import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			int[] arr = { Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) };
			Arrays.sort(arr);
			if (arr[1] - arr[0] >= arr[2] - arr[1]) {
				System.out.println(arr[1] - arr[0] - 1);
			} else {
				System.out.println(arr[2] - arr[1] - 1);
			}

		}
	}
}