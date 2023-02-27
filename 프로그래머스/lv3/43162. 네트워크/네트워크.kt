class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        var result = IntArray(n) { 0 }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) continue
                if (computers[i][j] == 0) continue
                when {
                    result[i] != 0 && result[j] != 0 -> {
                        when {
                            result[i] > result[j] -> {
                                result = result.map { if (it == result[i]) result[j] else it }.toIntArray()
                            }
                            result[i] < result[j] -> {
                                result = result.map { if (it == result[j]) result[i] else it }.toIntArray()
                            }
                        }
                    }
                    result[i] != 0 -> result[j] = result[i]
                    result[j] != 0 -> result[i] = result[j]
                    result[i] == 0 && result[j] == 0 -> {
                        answer++
                        result[i] = answer
                        result[j] = answer
                    }
                }
            }
        }
        return result.filter { it != 0 }.distinct().size + result.filter { it == 0 }.size
    }
}