import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int M;
	static List<Pos> house = new ArrayList<>();
	static List<Pos> chicken = new ArrayList<>();
	static int[][] dist;
	static Stack<Integer> used = new Stack<>();
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st2.nextToken());
				
				if (num == 1) house.add(new Pos(i, j));
				else if (num == 2) chicken.add(new Pos(i, j));
			}
		}
		
		dist = new int[house.size()][chicken.size()];
		
		for (int i = 0; i < house.size(); i++) {
			for (int j = 0; j < chicken.size(); j++) {
				Pos h = house.get(i);
				Pos c = chicken.get(j);
				dist[i][j] = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
			}
		}
		
		calc(0, 0);
		
		System.out.println(result);
	}

	public static void calc(int index, int selected) {
	    if (selected == M) {
	        int sum = 0;
	        for (int i = 0; i < house.size(); i++) {
	            int min = Integer.MAX_VALUE;
	            for (int j = 0; j < M; j++) {
	                min = Math.min(min, dist[i][used.get(j)]);
	            }
	            sum += min;
	        }
	        result = Math.min(result, sum);
	    } else if (index < chicken.size()) {
	        used.push(index);
	        calc(index + 1, selected + 1);
	        used.pop();
	        calc(index + 1, selected);
	    }
	}
}