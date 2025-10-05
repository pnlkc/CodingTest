fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().split(" ").map { it.toInt() } }
    val p = readln().toInt()
    val pL = Array(n) { BooleanArray(n) }
    val dp = Array(n) { Array(n) { 0 to 0 } }

    for (i in 0 until p) {
        val (r, c) = readln().split(" ").map { it.toInt() }

        pL[r - 1][c - 1] = true
    }

    dp[0][0] = map[0][0] to if (pL[0][0]) 1 else 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i + 1 < n) {
                if (dp[i + 1][j].first < dp[i][j].first + map[i + 1][j]) {
                    dp[i + 1][j] = dp[i][j].first + map[i + 1][j] to dp[i][j].second + if (pL[i + 1][j]) 1 else 0
                } else if (dp[i + 1][j].first == dp[i][j].first + map[i + 1][j]) {
                    dp[i + 1][j] = dp[i + 1][j].first to maxOf(dp[i + 1][j].second, dp[i][j].second + if (pL[i + 1][j]) 1 else 0)
                }
            }

            if (j + 1 < n) {
                if (dp[i][j + 1].first < dp[i][j].first + map[i][j + 1]) {
                    dp[i][j + 1] = dp[i][j].first + map[i][j + 1] to dp[i][j].second + if (pL[i][j + 1]) 1 else 0
                } else if (dp[i][j + 1].first == dp[i][j].first + map[i][j + 1]) {
                    dp[i][j + 1] = dp[i][j + 1].first to maxOf(dp[i][j + 1].second, dp[i][j].second + if (pL[i][j + 1]) 1 else 0)
                }
            }
        }
    }

    println("${dp[n - 1][n - 1].first} ${dp[n - 1][n - 1].second}")
}