class Solution {
    fun solution(array: IntArray, n: Int): Int {
        return array.filter { if (n - it >= 0) { n - it } else { it - n } == array.minOf { if (n - it >= 0) { n - it } else { it - n } } }.minOrNull()!!
    }
}