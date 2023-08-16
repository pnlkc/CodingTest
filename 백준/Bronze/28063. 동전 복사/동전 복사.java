import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if (N == 1) {
			System.out.println(0);
		} else if ((x == 1 && y == N) || (x == N && y == 1) || (x == 1 && y == 1) || (x == N && y == N)) {
			System.out.println(2);
		} else if (x == 1 || y == 1 || x == N || y == N) {
			System.out.println(3);
		} else {
            System.out.println(4);
        }
	}
}