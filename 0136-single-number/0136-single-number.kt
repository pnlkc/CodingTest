class Solution {
    fun singleNumber(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        for ((k, v) in map) {
            if (v == 1) return k
        }

        return 0
    }
}