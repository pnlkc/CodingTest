fun main() {
    val N = readln().toInt()
    val map = Array(N) { IntArray(N) }
    val dp = Array(N) { LongArray(N) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    dp[0][0] = 1

    for (i in 0 until N) {
        for (j in i until N) {
            val num1 = map[i][j]

            if (num1 > 0) {
                if (j + num1 < N) dp[i][j + num1] += dp[i][j]
                if (i + num1 < N) dp[i + num1][j] += dp[i][j]
            }

            if (i != j) {
                val num2 = map[j][i]
                if (num2 > 0) {
                    if (j + num2 < N) dp[j + num2][i] += dp[j][i]
                    if (i + num2 < N) dp[j][i + num2] += dp[j][i]
                }
            }
        }
    }

    println(dp[N - 1][N - 1])
}