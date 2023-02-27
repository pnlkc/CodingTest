class Solution {
    fun solution(sides: IntArray): Int {
        var answer: Int = 0
        sides.sort()
        for (i in 1 until sides.sum()) {
            if (i < sides[1] && i + sides[0] <= sides[1]) continue else answer++
        }
        return answer
    }
}