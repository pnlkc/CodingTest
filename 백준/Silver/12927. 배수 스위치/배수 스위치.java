import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int cnt = 0;
		
		for (int i = 1; i <= arr.length; i++) {
			if (arr[i - 1] == 'Y') {
				cnt++;
				for (int j = i; j <= arr.length; j += i) {
					if (arr[j - 1] == 'Y') {
						arr[j - 1] = 'N';
					} else {
						arr[j - 1] = 'Y';
					}
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'Y') {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(cnt);
	}
}