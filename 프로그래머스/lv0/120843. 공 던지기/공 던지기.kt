class Solution {
    fun solution(numbers: IntArray, k: Int): Int {
        val i = (k * 2 - 1) % numbers.size - 1
        return if (i < 0) numbers.last() else numbers[i]
    }
}