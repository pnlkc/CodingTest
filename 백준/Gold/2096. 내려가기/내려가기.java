import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] min = new int[3];
		int[] max = new int[3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[] tempMin = new int[3];
			int[] tempMax = new int[3];
			tempMin[0] = a + Math.min(min[0], min[1]);
			tempMin[1] = b + Math.min(min[0], Math.min(min[1], min[2]));
			tempMin[2] = c + Math.min(min[1], min[2]);
			tempMax[0] = a + Math.max(max[0], max[1]);
			tempMax[1] = b + Math.max(max[0], Math.max(max[1], max[2]));
			tempMax[2] = c + Math.max(max[1], max[2]);
			min = tempMin;
			max = tempMax;
		}
		
		System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
	}
}