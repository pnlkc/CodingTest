fun main() {
    val N = readln().toInt()
    val K = readln().toInt()
    val NUM = 1_000_000_003
    val dp = Array(N + 1) { IntArray(K + 1) }

    for (i in 0..N) {
        dp[i][0] = 1
        dp[i][1] = i
    }

    for (i in 2..N) {
        for (j in 2..K) {
            dp[i][j] += dp[i - 1][j]
            dp[i][j] %= NUM
            dp[i][j] += dp[i - 2][j - 1]
            dp[i][j] %= NUM
        }
    }

    println((dp[N - 3][K - 1] + dp[N - 1][K]) % NUM)
}
