class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val distinct = nums.distinct()
        
        distinct.forEachIndexed { idx, i -> nums[idx] = i }

        return distinct.size
    }
}