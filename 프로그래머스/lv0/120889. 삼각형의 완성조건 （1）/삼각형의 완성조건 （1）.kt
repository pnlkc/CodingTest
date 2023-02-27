class Solution {
    fun solution(sides: IntArray): Int {
        return if (sides.sum() > sides.maxOrNull()!! * 2) 1 else 2
    }
}