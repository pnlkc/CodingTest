class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var size = nums.size
        
        for (i in nums.indices) {
            if (nums[i] == `val`) {
                nums[i] = 101
                size--
            }
        }
        
        nums.sort()
        
        return size
    }
}