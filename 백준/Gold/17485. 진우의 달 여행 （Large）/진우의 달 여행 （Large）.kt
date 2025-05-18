fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    val dp = Array(N) { Array(M) { IntArray(3) { Int.MAX_VALUE } } }

    for (i in 0 until M) {
        dp[0][i].fill(map[0][i])
    }

    for (i in 1 until N) {
        for (j in 0 until M) {
            if (j + 1 < M) {
                dp[i][j][0] = map[i][j] + minOf(
                    dp[i - 1][j + 1][1],
                    dp[i - 1][j + 1][2],
                )
            }

            dp[i][j][1] = map[i][j] + minOf(
                dp[i - 1][j][0],
                dp[i - 1][j][2],
            )

            if (j - 1 >= 0) {
                dp[i][j][2] = map[i][j] + minOf(
                    dp[i - 1][j - 1][0],
                    dp[i - 1][j - 1][1],
                )
            }
        }
    }

    println(dp[N - 1].minOf { it.minOf { it } })
}
