import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for (int tc = 1; tc <= 10; tc++) {
    		int N = Integer.parseInt(br.readLine());
    		int[][] map = new int[N][N];
    		
    		for (int i = 0; i < N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for (int j = 0; j < N; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		int cnt = 0;
    		
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				if (map[i][j] != 1) continue;
    				
    				if (i + 1 < N) {
    					for (int k = i + 1; k < N; k++) {
        					if (map[k][j] == 2) {
        						cnt++;
        						break;
        					} else if (map[k][j] == 1) {
        						map[k][j] = 0;
        					}
        				}
    				}
    			}
    		}
    		
    		sb.append("#" + tc + " " + cnt).append("\n");
    	}
    	
    	System.out.println(sb);
	}
}