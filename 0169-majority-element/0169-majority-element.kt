class Solution {
    fun majorityElement(nums: IntArray): Int {
        val cnt = mutableMapOf<Int, Int>()
        var maxCnt = 0
        var result = 0
        
        for (num in nums) {
            cnt[num] = cnt.getOrDefault(num, 0) + 1
            
            if (cnt[num]!! > maxCnt) {
                result = num
                maxCnt = cnt[num]!!
            }
        }
        
        return result
    }
}