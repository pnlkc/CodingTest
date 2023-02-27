class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer = 0
        val table = Array(n) { Array(n) { -1 } }

        for (i in 0 until n) {
            table[i][i] = 0
        }

        fares.forEach {
            table[it[0] - 1][it[1] - 1] = it[2]
            table[it[1] - 1][it[0] - 1] = it[2]
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    val ji = table[j][i]
                    val ki = table[k][i]
                    val jk = table[j][k]
                    if (ji != -1 && ki != -1) {
                        if (jk == -1 || ji + ki < jk) table[j][k] = ji + ki
                    }
                }
            }
        }

        answer = table[s - 1][a - 1] + table[s - 1][b - 1]

        for (i in 0 until n) {
            val si = table[s - 1][i]
            val ia = table[i][a - 1]
            val ib = table[i][b - 1]
            if (si != -1 && ia != -1 && ib != -1) {
                if (si + ia + ib < answer) answer = si + ia + ib
            }
        }

        return answer
    }
}