class Solution {
    fun solution(n: Int): IntArray {
        return (1..n).filter { n % it == 0 }.toIntArray()
    }
}