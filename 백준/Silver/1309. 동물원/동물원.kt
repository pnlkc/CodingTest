fun main() {
    val n = readln().toInt()
    val dp = Array(n) { IntArray(3) } // 00 01 10
    val NUM = 9901

    dp[0].fill(1)

    for (i in 1 until n) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % NUM
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % NUM
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % NUM
    }

    println(dp[n - 1].sum() % NUM)
}