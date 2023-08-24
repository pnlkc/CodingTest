import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Box implements Comparable<Box> {
	int idx, time;

	public Box(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}

	@Override
	public int compareTo(Box o) {
		return time - o.time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		int[] life = new int[N * 2];
		int[] belt = new int[N * 2];
		boolean[] hasBox = new boolean[N * 2];
		PriorityQueue<Box> boxQ = new PriorityQueue<>();
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		// 각 칸의 내구도 초기화
		for (int i = 0; i < N * 2; i++) {
			life[i] = Integer.parseInt(st2.nextToken());
			belt[i] = i;
		}

		int cnt = 0; // 망가진 칸의 개수
		int time = 0;
		while (cnt < K) { // 망가진 칸의 개수가 K보다 작으면 반복
			time++;
			
			// 벨트 한칸 회전
			int last = belt[0];
			for (int i = 0; i < N * 2 - 1; i++) {
				int temp = belt[i + 1];
				belt[i + 1] = last;
				last = temp;
			}
			belt[0] = last;

			int out = belt[N - 1]; // 내리는 위치
			if (hasBox[out]) {
				hasBox[out] = false;
			}

			// 로봇 이동 (가장 먼저 올라간 로봇 부터 이동)
			PriorityQueue<Box> tempQ = new PriorityQueue<>();
			while (!boxQ.isEmpty()) { // 박스 전부 탐색
				Box c = boxQ.poll();
				if (!hasBox[c.idx])
					continue;

				int nIdx = c.idx + 1;
				if (nIdx == N * 2)
					nIdx = 0;

				if (hasBox[nIdx]) {
					tempQ.offer(c);
				} else {
					if (life[nIdx] > 0) {
						if (nIdx != belt[N - 1]) {
							tempQ.offer(new Box(nIdx, c.time));
							hasBox[nIdx] = true;
						}
						hasBox[c.idx] = false;
						if (--life[nIdx] <= 0)
							cnt++;
					} else {
						tempQ.offer(c);
					}
				}

			}
			boxQ = tempQ;

			// 올리는 위치에 로봇 올리기
			int in = belt[0];
			if (!hasBox[in] && life[in] > 0) {
				boxQ.offer(new Box(in, time));
				hasBox[in] = true;
				if (--life[in] <= 0)
					cnt++;
			}
		}

		System.out.println(time);
	}
}