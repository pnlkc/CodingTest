fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val dp = Array(100_001) { IntArray(4) }
    val DIV = 1_000_000_009

    dp[1][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1

    for (i in 4..100_000) {
        dp[i][1] += dp[i - 1][2] + dp[i - 1][3]
        dp[i][2] += dp[i - 2][1] + dp[i - 2][3]
        dp[i][3] += dp[i - 3][1] + dp[i - 3][2]
        dp[i] = dp[i].map { it % DIV }.toIntArray()
    }

    for (tc in 1..T) {
        val n = readln().toInt()

        sb.appendLine(dp[n].sumOf { it.toLong() } % DIV)
    }

    print(sb)
}