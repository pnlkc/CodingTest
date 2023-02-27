class Solution {
    fun solution(dot: IntArray): Int {
        return when {
            dot[0] < 0 -> if (dot[1] > 0) 2 else 3
            else -> if (dot[1] > 0) 1 else 4
        }
    }
}