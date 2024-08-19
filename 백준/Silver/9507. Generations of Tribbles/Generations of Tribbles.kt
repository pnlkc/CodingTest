fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()
    val dp = LongArray(68)

    dp[0] = 1L
    dp[1] = 1L
    dp[2] = 2L
    dp[3] = 4L

    for (i in 4..67){
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]
    }

    for (tc in 1..t) {
        sb.appendLine(dp[readln().toInt()])
    }

    print(sb)
}