class Solution {
    fun solution(numLog: IntArray): String {
        var answer = ""
        for (i in 1..numLog.lastIndex) {
            when {
                numLog[i] - numLog[i - 1] == 1 -> answer += "w"
                numLog[i] - numLog[i - 1] == -1 -> answer += "s"
                numLog[i] - numLog[i - 1] == 10 -> answer += "d"
                numLog[i] - numLog[i - 1] == -10 -> answer += "a"
            }
        }
        return answer
    }
}