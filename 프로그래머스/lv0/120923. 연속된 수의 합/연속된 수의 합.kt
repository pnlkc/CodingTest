class Solution {
    fun solution(num: Int, total: Int): IntArray {
        val answer = mutableListOf<Int>()
        val n = total / num
        if (num % 2 == 0) answer.addAll(n - num / 2 + 1..n + num / 2)
        else answer.addAll(n - num / 2..n + num / 2)
        return answer.toIntArray()
    }
}