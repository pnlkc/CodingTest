import kotlin.math.sqrt
class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        for (i in 0..d step k) {
            answer += (sqrt((d.toDouble() * d - i.toDouble() * i)) / k).toLong() + 1
        }
        return answer
    }
}