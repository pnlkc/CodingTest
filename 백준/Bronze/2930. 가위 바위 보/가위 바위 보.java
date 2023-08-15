import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = 0;
		int maxScore = 0;
		int R = Integer.parseInt(br.readLine());
		int[] cnt = { 0, 0, 0 };
		String str = br.readLine();
		for (int i = 0; i < R; i++) {
			if (str.charAt(i) == 'R') {
				cnt[0]++;
			} else if (str.charAt(i) == 'S') {
				cnt[1]++;
			} else {
				cnt[2]++;
			}
		}

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[R][3];
		for (int n = 0; n < N; n++) {
			String str2 = br.readLine();
			for (int i = 0; i < R; i++) {
				if (str2.charAt(i) == 'R') {
					arr[i][0]++;

					if (str.charAt(i) == 'P') {
						score += 2;
					} else if (str.charAt(i) == 'R') {
						score += 1;
					}
				} else if (str2.charAt(i) == 'S') {
					arr[i][1]++;

					if (str.charAt(i) == 'R') {
						score += 2;
					} else if (str.charAt(i) == 'S') {
						score += 1;
					}
				} else {
					arr[i][2]++;

					if (str.charAt(i) == 'S') {
						score += 2;
					} else if (str.charAt(i) == 'P') {
						score += 1;
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			int max = 0;
			max = Math.max(max, arr[i][2] * 2 + arr[i][1]);
			max = Math.max(max, arr[i][1] * 2 + arr[i][0]);
			max = Math.max(max, arr[i][0] * 2 + arr[i][2]);
			maxScore += max;
		}

		System.out.println(score);
		System.out.println(maxScore);
	}
}