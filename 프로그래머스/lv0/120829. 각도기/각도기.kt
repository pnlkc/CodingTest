class Solution {
    fun solution(angle: Int): Int {
        return when {
            angle == 90 -> 2
            angle == 180 -> 4
            angle < 90 -> 1
            else -> 3
        }
    }
}