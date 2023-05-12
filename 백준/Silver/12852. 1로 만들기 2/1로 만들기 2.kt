fun main() {
    val n = readln().toInt()
    val sb = StringBuilder("$n")
    val dp = Array(n + 1) { Int.MAX_VALUE to Int.MAX_VALUE }
    dp[1] = 0 to 0

    for (i in 1 until n) {
        val (depth, nextNum) = dp[i]
        if (depth == Int.MAX_VALUE) continue

        if (i * 3 <= n && dp[i * 3].first > depth + 1) dp[i * 3] = depth + 1 to i
        if (i * 2 <= n && dp[i * 2].first > depth + 1) dp[i * 2] = depth + 1 to i
        if (dp[i + 1].first > depth + 1) dp[i + 1] = depth + 1 to i
    }

    var num = n
    repeat(dp[n].first) {
        sb.append(" ${dp[num].second}")
        num = dp[num].second
    }

    println(dp[n].first)
    println(sb)
}