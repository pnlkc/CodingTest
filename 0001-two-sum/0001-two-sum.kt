class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(0, 0)
        
        for (i in 0 until nums.lastIndex) {
            for (j in i + 1..nums.lastIndex) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i
                    result[1] = j
                    break
                }
            }
        }
        
        return result
    }
}