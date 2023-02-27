class Solution {
    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        val answer: IntArray = intArrayOf(0, 0)
        keyinput.forEach { 
            when (it) {
                "right" -> if (answer[0] < board[0] / 2) answer[0]++
                "left" -> if (answer[0] * -1 < board[0] / 2) answer[0]--
                "up" -> if (answer[1] < board[1] / 2) answer[1]++
                "down" -> if (answer[1] * -1 < board[1] / 2) answer[1]--
            }
        }
        return answer
    }
}