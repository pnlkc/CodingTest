class Solution {
    fun solution(array: IntArray): IntArray {
        return intArrayOf(array.maxOrNull()!!, array.indexOf(array.maxOrNull()!!))
    }
}