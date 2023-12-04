import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Pos[] arr = new Pos[N];
		int sum = 0;
		int S = Integer.MIN_VALUE;
		int E = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i] = new Pos(x, y);
		}
		
		Arrays.sort(arr, Comparator.comparing(Pos::getS));

		for (int i = 0; i < N; i++) {
			Pos c = arr[i];
			
			if (c.s <= E) {
				if (c.e > E) {
					E = c.e;
				}
			} else {
				sum += E - S;
				S = c.s;
				E = c.e;
			}
		}
		
		sum += E - S;
		
		System.out.println(sum);
	}
}

class Pos {
	int s, e;

	public Pos(int s, int e) {
		this.s = s;
		this.e = e;
	}

	public int getS() {
		return s;
	}
}