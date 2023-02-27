class Solution {
    fun solution(denum1: Int, num1: Int, denum2: Int, num2: Int): IntArray {
        val answer = intArrayOf(denum1 * num2 + denum2 * num1, num1 * num2)
        p@while (true) {
            for (i in 2..answer.minOrNull()!!) {
                if (answer[0] % i == 0 && answer[1] % i == 0) {
                    answer[0] /= i
                    answer[1] /= i
                    continue@p
                }
            }
            break
        }
        return answer
    }
}