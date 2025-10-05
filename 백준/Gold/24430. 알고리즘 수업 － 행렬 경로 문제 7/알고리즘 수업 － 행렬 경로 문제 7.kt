data class Data(var sum: Int = 0, var cnt: Int = 0)

fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().split(" ").map { it.toInt() } }
    val p = readln().toInt()
    val pL = Array(n) { IntArray(n) }
    val dp = Array(n) { Array(n) { Data() } }

    for (i in 0 until p) {
        val (r, c) = readln().split(" ").map { it.toInt() }

        pL[r - 1][c - 1] = 1
    }

    dp[0][0] = Data(map[0][0], pL[0][0])

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i + 1 < n){
                val nSumA = dp[i][j].sum + map[i + 1][j]
                val nCntA = dp[i][j].cnt + pL[i + 1][j]

                if (dp[i + 1][j].sum < nSumA) {
                    dp[i + 1][j].sum = nSumA
                    dp[i + 1][j].cnt = nCntA
                } else if (dp[i + 1][j].sum == nSumA) {
                    dp[i + 1][j].cnt = maxOf(dp[i + 1][j].cnt, nCntA)
                }

            }

            if (j + 1 < n) {
                val nSumB = dp[i][j].sum + map[i][j + 1]
                val nCntB = dp[i][j].cnt + pL[i][j + 1]

                if (dp[i][j + 1].sum < nSumB) {
                    dp[i][j + 1].sum = nSumB
                    dp[i][j + 1].cnt = nCntB
                } else if (dp[i][j + 1].sum == nSumB) {
                    dp[i][j + 1].cnt = maxOf(dp[i][j + 1].cnt, nCntB)
                }
            }
        }
    }

    println("${dp[n - 1][n - 1].sum} ${dp[n - 1][n - 1].cnt}")
}