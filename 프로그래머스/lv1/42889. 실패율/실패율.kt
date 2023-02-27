class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()
        var failRatio = mutableMapOf<Int, Double>()
        
        for (i in 1..N) {
            var notCleared = stages.count { it == i }
            var reach = stages.count { it >= i }
            val result = notCleared.toDouble() / reach.toDouble()
            failRatio[i] = if(result.isNaN()) 0.0 else result
        }
        
        answer = failRatio.toList()
            .sortedWith(compareByDescending<Pair<Int, Double>> { it.second }
                    .thenBy { it.first })
            .toMap().keys.toIntArray()
        println(answer)
        return answer
    }
}