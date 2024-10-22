fun main() {
    val N = readln().toInt()
    val dp = Array(N + 1) { IntArray(10) }
    for (i in 1..10) {
        dp[0][10 - i] = i
    }

    for (i in 1 until N) {
        dp[i][9] += dp[i - 1][9]

        for (j in 8 downTo 0) {
            dp[i][j] += dp[i - 1][j]
            dp[i][j] += dp[i][j + 1]
            dp[i][j] %= 10_007
        }
    }

    println(dp[N - 1][0])
}