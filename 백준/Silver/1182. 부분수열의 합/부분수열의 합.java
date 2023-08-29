import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int S = Integer.parseInt(st1.nextToken());
		arr = new int[N];
		List<Integer> aL = new ArrayList<>();
		List<Integer> bL = new ArrayList<>();
		int cnt = 0;

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}

		aL = calc(0, N / 2 - 1, aL);
		bL = calc(N / 2, N - 1, bL);

		if (aL != null) {
			aL.sort(Comparator.naturalOrder());
			bL.sort(Comparator.naturalOrder());
			
			for (int i = 0; i < aL.size(); i++) {
				int num = aL.get(i);

				if (num == S)
					cnt++;

				cnt += findCnt(S - num, bL);
			}
		}

		for (int i = 0; i < bL.size(); i++) {
			if (bL.get(i) == S)
				cnt++;
		}

		System.out.println(cnt);
	}

	public static List<Integer> calc(int s, int e, List<Integer> l) {
		if (s > e) {
			return null;
		}

		List<Integer> list = l;

		for (int i = s; i <= e; i++) {
			List<Integer> tList = new ArrayList<>();
			tList.add(arr[i]);

			for (int num : list) {
				tList.add(num);
				tList.add(num + arr[i]);
			}

			list = tList;
		}

		return list;
	}

	public static int findCnt(int num, List<Integer> list) {
		int s = 0;
		int e = list.size() - 1;

		while (s < list.size() && list.get(s) < num) {
			s++;
		}

		while (e >= 0 && list.get(e) > num) {
			e--;
		}

		return Math.max(0, e - s + 1);
	}
}