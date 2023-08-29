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
		long cnt = 0;
		if (S == 0) cnt--;

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}

		calc(0, N / 2, 0, aL);
		calc(N / 2, N, 0, bL);

		aL.sort(Comparator.naturalOrder());
		bL.sort(Comparator.naturalOrder());
		
		int prevA = Integer.MIN_VALUE;
		int prevR = 0;
		for (int i = 0; i < aL.size(); i++) {
			int num = aL.get(i);
			
			if (num == prevA) {
				cnt += prevR;
			} else {
				int r = findCnt(S - num, bL);
				cnt += r;
				prevA = num;
				prevR = r;
			}
		}

		System.out.println(cnt);
	}

	public static void calc(int s, int e, int num, List<Integer> list) {
		if (s == e) {
			list.add(num);
			return;
		}

		calc(s + 1, e, num, list);
		calc(s + 1, e, num + arr[s], list);
	}

	public static int findCnt(int num, List<Integer> list) {
		int cnt = 0;
		int s = 0;
		int e = list.size() - 1;

		while (s <= e) {
			int m = (s + e) / 2;
			
			if (list.get(m) < num) {
				s = m + 1;
			} else if (list.get(m) > num) {
				e = m - 1;
			} else {
				cnt++;
				
				int lm = m - 1;
				while (lm >= 0 && list.get(lm) == num) {
					cnt++;
					lm--;
				}
				
				int rm = m + 1;
				while (rm < list.size() && list.get(rm) == num) {
					cnt++;
					rm++;
				}
				
				break;
			}
		}

		return cnt;
	}
}