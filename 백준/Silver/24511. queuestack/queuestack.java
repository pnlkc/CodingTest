import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int type = Integer.parseInt(st1.nextToken());
			int num = Integer.parseInt(st2.nextToken());
			if (type == 0) {
				cnt++;
				deque.offerLast(num);
			}
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st3.nextToken());
			deque.offerFirst(num);
			sb.append(deque.pollLast());
			if (i != M - 1)
				sb.append(" ");
		}

		System.out.println(sb);
	}
}