class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        for (i in 1..h) {
            answer += ((i-1) * w.toDouble() / h.toDouble()).toLong()
        }
        return answer * 2
    }
}