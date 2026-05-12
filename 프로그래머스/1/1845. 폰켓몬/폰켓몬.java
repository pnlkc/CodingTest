import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
                cnt++;
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        return Math.min(cnt, nums.length / 2);
    }
}