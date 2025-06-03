fun main() {
    val n = readln().toInt()
    val NUM = 1_000_000_009
    val dp = IntArray(maxOf(3, n + 1))

    dp[0] = 1
    dp[1] = 1
    dp[2] = 1

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 3]) % NUM
    }

    println(dp[n])
}