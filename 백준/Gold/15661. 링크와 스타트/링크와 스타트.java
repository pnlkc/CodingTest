import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer> list = new ArrayList<>();
		calc(0, list);

		System.out.println(min);
	}

	public static void calc(int num, List<Integer> list) {
		if (num >= N) {
			return;
		}
		
		List<Integer> left = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (!list.contains(i)) {
				left.add(i);
			}
		}

		int r1 = sum(list);
		int r2 = sum(left);

		min = Math.min(min, Math.abs(r1 - r2));

		calc(num + 1, list);

		List<Integer> temp = new ArrayList<>(list);
		temp.add(num);
		calc(num + 1, temp);
	}

	public static int sum(List<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				sum += map[list.get(i)][list.get(j)] + map[list.get(j)][list.get(i)];
			}
		}

		return sum;
	}
}