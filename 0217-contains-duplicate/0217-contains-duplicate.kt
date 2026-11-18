class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        return if (nums.size != nums.distinct().size) true else false 
    }
}