import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		boolean[][] isVisit = new boolean[2001][2001];
			
		Queue<Data> q = new LinkedList<>();
		isVisit[0][1] = true;
		q.offer(new Data(1, 0, 0));
		
		while (!q.isEmpty()) {
			Data c = q.poll();
			if (c.num == S) {
				System.out.println(c.cnt);
				return;
			}
			
			if (!isVisit[c.num][c.num]) {
				isVisit[c.num][c.num] = true;
				q.offer(new Data(c.num, c.num, c.cnt + 1));
			}
			
			if (c.num + c.copy <= 2000 && !isVisit[c.copy][c.num + c.copy]) {
				isVisit[c.copy][c.num + c.copy] = true;
				q.offer(new Data(c.num + c.copy, c.copy, c.cnt + 1));
			}
			
			if (c.num - 1 >= 0 && !isVisit[c.copy][c.num - 1]) {
				isVisit[c.copy][c.num - 1] = true;
				q.offer(new Data(c.num - 1, c.copy, c.cnt + 1));
			}
		}
		
	}
}

class Data {
	int num, copy, cnt;

	public Data(int num, int copy, int cnt) {
		this.num = num;
		this.copy = copy;
		this.cnt = cnt;
	}
}