class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var result = 0

        for (i in nums.indices) {
            if (nums[i] < target) result++ else break
        }

        return result
    }
}