import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, k, result;
	static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		calc(3, 3);
	}
	
	public static void calc(int x, int y) {
		if (map[r][c] == k) {
			System.out.println(result);
			return;
		}
		
		result++;
		
		if (result > 100) {
			System.out.println(-1);
			return;
		}
		
		if (y >= x) {
			rCalc(x, y);
		} else {
			cCalc(x, y);
		}
	}
	
	public static void rCalc(int x, int y) {
		Map<Integer, Integer> cnt = new HashMap<>();
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing(Data::getCnt).thenComparing(Data::getNum));
		int[][] temp = new int[101][101];
		int max = 0;
		
		for (int i = 0; i < y; i++) {
			pq.clear();
			cnt.clear();
			
			for (int j = 0; j < x; j++) {
				if (cnt.get(map[i][j]) == null) {
					cnt.put(map[i][j], 1);
				} else {
					cnt.put(map[i][j], cnt.get(map[i][j]) + 1);
				}
			}
			
			for (int j : cnt.keySet()) {
				pq.add(new Data(j, cnt.get(j)));
			}
			
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j < 50; j++) {
				if (pq.isEmpty()) {
					break;
				}
				
				Data c = pq.poll();
				
				if (c.num == 0) {
					continue;
				}
				
				list.add(c.num);
				list.add(c.cnt);
			}
			
			max = Math.max(max, list.size());
			
			for (int j = 0; j < list.size(); j++) {
				temp[i][j] = list.get(j);
			}
		}
		
		map = temp;
		calc(max, y);
	}
	
	public static void cCalc(int x, int y) {
		Map<Integer, Integer> cnt = new HashMap<>();
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing(Data::getCnt).thenComparing(Data::getNum));
		int[][] temp = new int[101][101];
		int max = 0;
		
		for (int i = 0; i < x; i++) {
			pq.clear();
			cnt.clear();
			
			for (int j = 0; j < y; j++) {
				if (cnt.get(map[j][i]) == null) {
					cnt.put(map[j][i], 1);
				} else {
					cnt.put(map[j][i], cnt.get(map[j][i]) + 1);
				}
			}
			
			for (int j : cnt.keySet()) {
				pq.add(new Data(j, cnt.get(j)));
			}
			
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j < 50; j++) {
				if (pq.isEmpty()) {
					break;
				}
				
				Data c = pq.poll();
				
				if (c.num == 0) {
					continue;
				}
				
				list.add(c.num);
				list.add(c.cnt);
			}
			
			max = Math.max(max, list.size());
			
			for (int j = 0; j < list.size(); j++) {
				temp[j][i] = list.get(j);
			}
		}
		
		map = temp;
		calc(x, max);
	}
}

class Data {
	int num, cnt;

	public Data(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public int getCnt() {
		return cnt;
	}
}