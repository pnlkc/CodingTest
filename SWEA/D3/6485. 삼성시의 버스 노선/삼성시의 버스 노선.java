import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc = 1; tc <= T; tc++) {
    		int N = Integer.parseInt(br.readLine());
    		int[] cnt = new int[5001];
    		for (int i = 0; i < N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			for (int j = a; j <= b; j++) {
    				cnt[j]++;
    			}
    		}
    		sb.append("#" + tc);
    		
    		int P = Integer.parseInt(br.readLine());
    		for (int i = 0; i < P; i++) {
    			sb.append(" " + cnt[Integer.parseInt(br.readLine())]);
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
	}
    
}