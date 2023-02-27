class Solution {
    fun solution(balls: Int, share: Int): Int {
        var answer = 1L
        for (i in 0 until share) {
            answer *= balls - i
            answer /= i + 1
        }
        return answer.toInt()
    }
}