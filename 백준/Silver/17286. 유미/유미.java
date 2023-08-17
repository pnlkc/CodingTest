import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static Pos yumi;
	static Pos[] arr = new Pos[3];
	static double min = Double.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		yumi = new Pos(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()));
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			arr[i] = new Pos(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
		}
		
		calc(new ArrayList<>());
		
		System.out.println((int) min);
	}
	
	public static void calc(List<Integer> used) {
		if (used.size() == 3) {
			double sum = 0;
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					sum += calcDist(yumi, arr[used.get(i)]);
				} else {
					sum += calcDist(arr[used.get(i - 1)], arr[used.get(i)]);
				}
			}
			min = Math.min(min, sum);
		} else {
			for (int i = 0; i < 3; i++) {
				if (!used.contains(i)) {
					used.add(i);
					calc(used);
					used.remove(used.size() - 1);
				}
			}
		}
	}
	
	public static double calcDist(Pos p1, Pos p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
}