class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val answer = Array(n) { IntArray(n) { 0 } }
        for (r in results) {
            answer[r[0] - 1][r[1] - 1] = 1
            answer[r[1] - 1][r[0] - 1] = -1
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j || answer[i][j] != 0) continue
                for (k in 0 until n) {
                    if (answer[i][k] == 0 || answer[k][j] == 0) continue
                    if (answer[i][k] * answer[k][j] > 0) {
                        answer[i][j] = answer[i][k]
                        answer[j][i] = answer[i][k] * -1
                        break
                    }
                }
            }
        }
        return answer.count { it.count { it != 0 } == n - 1 }
    }
}