import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		hmap.put(0, 5);
		hmap.put(5, 0);
		hmap.put(1, 3);
		hmap.put(3, 1);
		hmap.put(2, 4);
		hmap.put(4, 2);
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] arr = new String[n][];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().split(" ");
		}
		
		for (int i = 0; i < arr[0].length; i++) {
			int tn = Integer.parseInt(arr[0][i]);
			int sum = 0;
			int fmax = 0;
			
			for (int j = 0; j < arr[0].length; j++) {
				if (j == i || j == hmap.get(i)) continue;
				fmax = Math.max(fmax, Integer.parseInt(arr[0][j]));
			}
			
			sum += fmax;
			
			for (int j = 1; j < n; j++) {
				int idx = 0;
				int smax = 0;
				
				for (int k = 0; k < arr[j].length; k++) {
					if (tn == Integer.parseInt(arr[j][k])) {
						idx = k;
						break;
					}
				}
				
				for (int k = 0; k < arr[j].length; k++) {
					if (k == idx || k == hmap.get(idx)) continue;
					smax = Math.max(smax, Integer.parseInt(arr[j][k]));
				}
				
				tn = Integer.parseInt(arr[j][hmap.get(idx)]);
				
				sum += smax;
			}
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}