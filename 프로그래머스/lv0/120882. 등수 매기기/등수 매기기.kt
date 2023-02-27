class Solution {
    fun solution(score: Array<IntArray>): IntArray {
        var answer: IntArray = IntArray(score.size) { 0 }
        var currentRank = 0
        var currentAvg = 0
        var equalNum = 0
        score.mapIndexed { i, a -> intArrayOf(a.sum(), i) }.sortedByDescending { it[0] }.forEach {
            if (it[0] == currentAvg) {
                answer[it[1]] = currentRank
                equalNum++
            } else {
                currentRank += 1 + equalNum
                equalNum = 0
                answer[it[1]] = currentRank
                currentAvg = it[0]
            }
        }
        return answer
    }
}