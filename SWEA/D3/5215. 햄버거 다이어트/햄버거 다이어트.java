import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
{
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			max = 0;
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int l = Integer.parseInt(input[1]);

			ArrayList<Integer> tL = new ArrayList<>();
			ArrayList<Integer> cL = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				String[] inputI = br.readLine().split(" ");
				tL.add(Integer.parseInt(inputI[0]));
				cL.add(Integer.parseInt(inputI[1]));
			}

			calc(0, n, l, 0, 0, tL, cL);

			System.out.println("#" + (tc + 1) + " " + max);
		}
	}

	public static void calc(int i, int n, int l, int sumT, int sumC, ArrayList<Integer> tL, ArrayList<Integer> cL) {
		if (i == n) {
			if (sumC <= l && max < sumT) max = sumT;
			return;
		}

		if (l >= sumC + cL.get(i)) calc(i + 1, n, l, sumT + tL.get(i), sumC + cL.get(i), tL, cL);
		calc(i + 1, n, l, sumT, sumC, tL, cL);
	}
}