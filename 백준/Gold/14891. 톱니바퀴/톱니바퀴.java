import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, Deque<Integer>> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<>();
		
		for (int i = 1; i <= 4; i++) {
			map.put(i, new ArrayDeque<>());
			String str = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				map.get(i).add(str.charAt(j) - '0');
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			move(n, d);
		}
		
		int result = 0;
		
		
		for (int i = 1; i <= 4; i++) {
			if (map.get(i).peek() == 1) {
				result += Math.pow(2, (i - 1));
			}
		}
		
		System.out.println(result);
	}
	
	public static void move(int n, int d) {
		boolean[] isVisit = new boolean[5];
		Queue<Command> q = new LinkedList<>();
		q.add(new Command(n, d));
		isVisit[n] = true;
		
		while (!q.isEmpty()) {
			Command c = q.poll();

			if (c.n > 1 && !isVisit[c.n - 1]) {
				List<Integer> temp1 = new ArrayList<>(map.get(c.n));
				List<Integer> temp2 = new ArrayList<>(map.get(c.n - 1));
				
				if (temp1.get(6) != temp2.get(2)) {
					q.offer(new Command(c.n - 1, c.d * -1));
					isVisit[c.n - 1] = true;
				}
			}
			
			if (c.n < 4 && !isVisit[c.n + 1]) {
				List<Integer> temp1 = new ArrayList<>(map.get(c.n));
				List<Integer> temp2 = new ArrayList<>(map.get(c.n + 1));
				
				if (temp1.get(2) != temp2.get(6)) {
					q.offer(new Command(c.n + 1, c.d * -1));
					isVisit[c.n + 1] = true;
				}
			}
			
			if (c.d == 1) {
				map.get(c.n).offerFirst(map.get(c.n).pollLast());
			} else {
				map.get(c.n).offerLast(map.get(c.n).pollFirst());
			}
		}
	}
}

class Command {
	int n, d;

	public Command(int n, int d) {
		this.n = n;
		this.d = d;
	}
}