class Solution {
    fun solution(n: Int, numlist: IntArray): IntArray {
        return numlist.filter { it % n == 0 }.toIntArray()
    }
}