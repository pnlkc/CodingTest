import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		boolean[] party = new boolean[M]; // 파티의 진실 거짓 여부 배열

		Set<Integer> know = new HashSet<>(); // 진실을 아는 사용자 set
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st2.nextToken());
		for (int i = 0; i < tc; i++) {
			know.add(Integer.parseInt(st2.nextToken()));
		}

		List<List<Integer>> visitor = new ArrayList<>(); // 파티의 방문자 리스트
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			visitor.add(new ArrayList<>());
			int num = Integer.parseInt(st3.nextToken());
			for (int j = 0; j < num; j++) {
				visitor.get(i).add(Integer.parseInt(st3.nextToken()));
			}
		}

		boolean isChange = true;
		while (isChange) {
			isChange = false;

			for (int i = 0; i < M; i++) { // 파티 방문자 리스트 탐색
				if (party[i]) continue;
				for (int num : visitor.get(i)) {
					if (know.contains(num)) {
						party[i] = true;
						isChange = true;
						know.addAll(visitor.get(i));
					}
				}
			}
		}

		int cnt = 0;
		for (boolean r : party) {
			if (!r)
				cnt++;
		}

		System.out.println(cnt);
	}
}