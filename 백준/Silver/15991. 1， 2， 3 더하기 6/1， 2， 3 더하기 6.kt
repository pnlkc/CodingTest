fun main() {
    val sb = StringBuilder()
    val dp = LongArray(50_001)
    val NUM = 1_000_000_009

    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..50000) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % NUM
    }

    repeat(readln().toInt()) {
        val n = readln().toInt()

        when (n) {
            1 -> sb.appendLine(1)
            2 -> sb.appendLine(2)
            3 -> sb.appendLine(2)
            else -> {
                var cnt = 0L

                cnt += dp[n / 2]
                cnt += dp[n / 2 - 1]
                cnt %= NUM

                sb.appendLine(cnt)
            }
        }
    }

    print(sb)
}