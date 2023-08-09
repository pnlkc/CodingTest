import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc = 1; tc <= T; tc++) {
    		String str = br.readLine();
    		int sum = 0;
    		int cnt = 0;
    		boolean prevLazer = false;
    		
    		for (int i = 0; i < str.length(); i++) {
    			if (str.charAt(i) == '(') {
    				if (i + 1 < str.length() && str.charAt(i + 1) == ')') {
    					sum += cnt;
    					prevLazer = true;
    				} else {
    					sum++;
    					cnt++;
    					prevLazer = false;
    				}
    			} else {
    				if (!prevLazer) {
    					cnt--;
    				} else {
    					prevLazer = false;
    				}
    			}
    		}
    		
    		sb.append("#" + tc + " " + sum).append("\n");
    	}
    	
    	System.out.println(sb);
	}
}