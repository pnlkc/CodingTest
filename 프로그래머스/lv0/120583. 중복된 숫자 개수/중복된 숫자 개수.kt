class Solution {
    fun solution(array: IntArray, n: Int): Int {
        return array.count { it == n }
    }
}