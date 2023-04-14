class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer = 0
        
        targets.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        
        var end = targets[0][0]

        targets.forEach { target ->
            if (target[0] >= end) {
                answer++
                end = target[1]
            } else {
                if (target[1] < end) end = target[1]
            }
        }

        return answer
    }
}