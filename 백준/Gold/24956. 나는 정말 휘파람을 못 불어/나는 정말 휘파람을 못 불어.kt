fun main() {
    val N = readln().toInt()
    val S = readln()
    val dp = Array(5) { IntArray(N + 1) }
    val NUM = 1_000_000_007

    dp[0][0] = 1

    for (i in 0 until N) {
        when (S[i]) {
            'W' -> dp[1][i + 1] = (dp[1][i + 1] + dp[0][i]) % NUM
            'H' -> dp[2][i + 1] = (dp[2][i + 1] + dp[1][i]) % NUM
            'E' -> {
                dp[4][i + 1] = (dp[4][i + 1] + dp[4][i]) % NUM
                dp[3][i + 1] = (dp[3][i + 1] + dp[2][i]) % NUM
                dp[4][i + 1] = (dp[4][i + 1] + dp[3][i]) % NUM
            }
        }

        for (j in 0..4) {
            dp[j][i + 1] = (dp[j][i + 1] + dp[j][i]) % NUM
        }
    }
    println(dp[4][N])
}