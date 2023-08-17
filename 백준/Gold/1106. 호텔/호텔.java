import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Cost {
	int c, p;

	public Cost(int c, int p) {
		this.c = c;
		this.p = p;
	}
}

public class Main {
	static int min = Integer.MAX_VALUE;
	static Cost[] costs;
	static int[] dp;
	static int C;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		costs = new Cost[N];
		dp = new int[C + 1];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st2.nextToken());
			int people = Integer.parseInt(st2.nextToken());
			
			costs[i] = new Cost(cost, people);
		}
		
		calc(0);
		System.out.println(dp[C]);
	}
	
	public static void calc(int cp) {
		if (cp == C) return;
		
		for (int i = 0; i < N; i++) {
			Cost cost = costs[i];
			int next = Math.min(C, cp + cost.p);
			
			if (dp[next] == 0 || dp[next] > dp[cp] + cost.c) {
				dp[next] = dp[cp] + cost.c;
				calc(next);
			}
		}
	}
}