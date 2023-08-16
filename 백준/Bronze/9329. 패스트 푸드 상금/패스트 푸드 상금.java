import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Data {
	int prize;
	List<Integer> list;
	
	public Data(int prize, List<Integer> list) {
		this.prize = prize;
		this.list = list;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st1.nextToken());
			int m = Integer.parseInt(st1.nextToken());
			int sum = 0;
			PriorityQueue<Data> pQueue = new PriorityQueue<>(new Comparator<Data>() {
				@Override
				public int compare(Data o1, Data o2) {
					return o2.prize - o1.prize;
				}});
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st2.nextToken());
				List<Integer> list = new ArrayList<>();
				
				for (int j = 0; j < num; j++) {
					int c = Integer.parseInt(st2.nextToken());
					list.add(c);
				}
				
				pQueue.add(new Data(Integer.parseInt(st2.nextToken()), list));
			}
			
			int[] sticker = new int[m + 1];
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				sticker[i] = Integer.parseInt(st3.nextToken());
			}
			
			while (!pQueue.isEmpty()) {
				Data c = pQueue.poll();
				int cnt = Integer.MAX_VALUE;

				for (int i : c.list) {
					cnt = Math.min(cnt, sticker[i]);
				}
				
				for (int i : c.list) {
					sticker[i] -= cnt;
				}
				
				sum += c.prize * cnt;
			}
			
			System.out.println(sum);
		}
	}
}