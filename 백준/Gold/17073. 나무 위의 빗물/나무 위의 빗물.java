import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double W = Double.parseDouble(st.nextToken());
		int[] nodeNum = new int[N + 1];
		int cnt = 0;
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			nodeNum[U]++;
			nodeNum[V]++;
		}
		
		for (int i = 2; i <= N; i++) {
			if (nodeNum[i] == 1) cnt++;
		}
		
		System.out.println(String.format("%.10f", W / cnt));
	}
}