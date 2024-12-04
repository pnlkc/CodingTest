import kotlin.math.pow

fun main() {
    val N = readln().toInt()
    val dp = Array(N + 1) { IntArray(21) }
    val NUM = 1_000_000_000
    var prev = 1
    var cnt = 0

    dp[1][0] = 1

    for (i in 2..N) {
        if (i % 2 == 0) {
            if (prev * 2 == i) {
                dp[i][++cnt] = 1
                prev *= 2
            }

            for (j in cnt downTo 0) {
                dp[i][j] += dp[i - (2.0.pow(j)).toInt()][j]
                dp[i][j] += dp[i][j + 1]
                dp[i][j] %= NUM
            }
        } else {
            dp[i][0] = dp[i - 1][0]
        }
    }

    println(dp[N][0])
}