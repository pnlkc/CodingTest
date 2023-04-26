class Solution {
    fun solution(a: Int, b: Int): Int {
        return maxOf((a.toString() + b.toString()).toInt(), 2 * a * b)
    }
}