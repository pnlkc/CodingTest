import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			Arrays.sort(arr);
			
			System.out.println("Scenario #" + i + ":");
			if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			System.out.println();
		}
	}
}