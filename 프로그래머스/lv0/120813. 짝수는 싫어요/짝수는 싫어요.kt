class Solution {
    fun solution(n: Int): IntArray {
        return (1..n).filter { it % 2 != 0 }.toIntArray()
    }
}