fun main() {
    val N = readln().toInt()
    val dp = IntArray(N + 1)
    val NUM = 1_000_000_000

    dp[1] = 1

    for (i in 2..N) {
        dp[i] += dp[i - 1]
        if (i % 2 == 0) dp[i] += dp[i / 2]
        dp[i] %= NUM
    }

    println(dp[N])
}