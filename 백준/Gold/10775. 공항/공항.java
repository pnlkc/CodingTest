import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G + 1];
		int cnt = 0;
		
		for (int i = 0; i <= G; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= P; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (union(num)) {
				cnt++;
			} else {
				break;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static boolean union(int n) {
		int p = find(n);
		
		if (p == 0) {
			return false;
		}
		
		parent[p] = parent[p - 1];
		
		return true;
	}
	
	public static int find(int n) {
		if (parent[n] != n) {
			return parent[n] = find(parent[n]);
		}
		
		return parent[n];
	}
}
