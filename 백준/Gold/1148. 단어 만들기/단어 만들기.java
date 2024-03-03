import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int[][] map = new int[200000][26];
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int N = 0;

		while (!(input = br.readLine()).equals("-")) {
			for (char c : input.toCharArray()) {
				map[idx][c - 'A']++;
			}

			idx++;
			N++;
		}

		while (!(input = br.readLine()).equals("#")) {
			int[] cnt = new int[26];
			int[] r = new int[26];

			for (int i = 0; i < 26; i++) {
				r[i] = -1;
			}

			for (char c : input.toCharArray()) {
				if (r[c - 'A'] == -1) {
					r[c - 'A'] = 0;
				}

				cnt[c - 'A']++;
			}

			p: for (int i = 0; i < N; i++) {
				for (int j = 0; j < 26; j++) {
					if (map[i][j] > cnt[j])
						continue p;
				}

				for (int j = 0; j < 26; j++) {
					if (map[i][j] <= cnt[j] && map[i][j] > 0 && cnt[j] > 0)
						r[j]++;
				}
			}

			int min = Integer.MAX_VALUE;
			int max = 0;
			List<Character> minL = new ArrayList<>();
			List<Character> maxL = new ArrayList<>();

			for (int i = 0; i < 26; i++) {
				if (r[i] == -1)
					continue;

				if (r[i] > max) {
					max = r[i];
					maxL.clear();
					maxL.add((char) (i + 'A'));
				} else if (r[i] == max) {
					maxL.add((char) (i + 'A'));
				}

				if (r[i] < min) {
					min = r[i];
					minL.clear();
					minL.add((char) (i + 'A'));
				} else if (r[i] == min) {
					minL.add((char) (i + 'A'));
				}
			}

			for (char c : minL) {
				sb.append(c);
			}

			sb.append(" " + min + " ");

			for (char c : maxL) {
				sb.append(c);
			}

			sb.append(" " + max + "\n");
		}

		System.out.print(sb);
	}
}