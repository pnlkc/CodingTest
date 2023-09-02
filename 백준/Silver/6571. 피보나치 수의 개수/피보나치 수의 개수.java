import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			if (str.equals("0 0")) break;
			
			StringTokenizer st = new StringTokenizer(str);
			int cnt = 0;
			BigInteger a = new BigInteger(st.nextToken());
			BigInteger b = new BigInteger(st.nextToken());
			BigInteger[] arr = new BigInteger[500];
			arr[1] = BigInteger.ONE;
			arr[2] = new BigInteger("2");
			
			if (a.compareTo(BigInteger.ONE) <= 0 && b.compareTo(BigInteger.ONE) >= 0) cnt++;
			if (a.compareTo(arr[2]) <= 0 && b.compareTo(arr[2]) >= 0) cnt++;
			
			for (int i = 3; i < 1_000; i++) {
				arr[i] = arr[i - 1].add(arr[i - 2]);
				if (arr[i].compareTo(a) >= 0 && arr[i].compareTo(b) <= 0) {
					cnt++;
				} else if (arr[i].compareTo(b) > 0) {
					break;
				}
			}
			
			System.out.println(cnt);
		}
	}
}