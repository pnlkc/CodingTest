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
    		for (int i = 0; i < str.length(); i++) {
    			if (sum < i) {
    				cnt += i - sum;
    				sum = i;
    			}
    			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
    		}
    		sb.append("#" + tc + " " + cnt).append("\n");
    	}
    	
    	System.out.println(sb);
	}
}