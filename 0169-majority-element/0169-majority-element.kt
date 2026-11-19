class Solution {
    fun majorityElement(nums: IntArray): Int {
        var result = nums[0]
        var cnt = 1

        for (i in 1..nums.lastIndex) {
            if (cnt == 0) {
                result = nums[i]
                cnt++
            } else {
                if (result != nums[i]) {
                    cnt--
                } else {
                    cnt++
                }
            }
        }

        return result
    }
}