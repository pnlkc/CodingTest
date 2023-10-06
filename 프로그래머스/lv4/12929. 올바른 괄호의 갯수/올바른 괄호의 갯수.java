class Solution {
    public int solution(int n) {
    	int[] dp = new int[Math.max(4, n + 1)];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
    	
    	for (int i = 4; i <= n; i++) {
    		int num = 0;
    		
    		for (int j = 0; j < i; j++) {
    			num += dp[j] * dp[i - j - 1];
    		}
    		
    		dp[i] = num;
    	}
        
        return dp[n];
    }
}