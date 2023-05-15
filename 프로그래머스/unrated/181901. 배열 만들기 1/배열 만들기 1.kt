class Solution {
    fun solution(n: Int, k: Int): IntArray {
        return (1..n).filter { it % k == 0 }.toIntArray()
    }
}