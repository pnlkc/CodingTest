import java.util.*;

class Solution {
    public int solution(int n) {
        int num = 1000000007;
        long[] arr = new long[n + 1];
        
        arr[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            if (i % 2 != 0) continue; 
            
            arr[i] += arr[i - 2] * 3 + 2;
            arr[i] %= num;
            
            for (int j = i - 3; j >= 2; j--) {
                if (j % 2 != 0) continue;
                
                arr[i] += arr[j] * 2;
                arr[i] %= num;
            }
        }
        
        return (int) arr[n];
    }
}