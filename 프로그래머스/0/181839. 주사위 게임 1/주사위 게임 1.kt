import kotlin.math.*

class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer = when {
            a % 2 == 1 && b % 2 == 1 -> a * a + b * b
            a % 2 == 1 || b % 2 == 1 -> 2 * (a + b)
            else -> abs(a - b)
        }
        
        return answer
    }
}