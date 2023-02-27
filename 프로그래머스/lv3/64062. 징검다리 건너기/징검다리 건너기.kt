class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var min = stones.minOrNull()!!
        var max = stones.maxOrNull()!!
        while (max - min > 1) {
            val avg = (min + max) / 2
            if (calc(stones, avg, k)) min = avg else max = avg
        }
        return stones.filter { it <= min }.maxOrNull()!!
    }

    fun calc(stones: IntArray, num: Int, k: Int): Boolean {
        var count = 0
        for (i in stones) {
            if (i - num < 0) {
                count++
                if (count == k) return false
            } else {
                count = 0
            }
        }
        return true
    }
}