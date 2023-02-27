class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer = ""
        val type = intArrayOf(0, 0, 0, 0)
        for (i in survey.indices) {
            val score = if (survey[i][0] > survey[i][1]) 4 - choices[i] else choices[i] - 4
            when {
                survey[i].contains('R') -> { type[0] += score }
                survey[i].contains('C') -> { type[1] += score }
                survey[i].contains('J') -> { type[2] += score }
                survey[i].contains('A') -> { type[3] += score }
            }
        }

        answer += if (type[0] <= 0)  "R" else "T"
        answer += if (type[1] <= 0)  "C" else "F"
        answer += if (type[2] <= 0)  "J" else "M"
        answer += if (type[3] <= 0)  "A" else "N"

        return answer
    }
}