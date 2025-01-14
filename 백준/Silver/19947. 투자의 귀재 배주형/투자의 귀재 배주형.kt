fun main() {
    val (H, Y) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(11)

    dp[0] = H

    for (i in 1..10) {
        dp[i] = maxOf(dp[i], (dp[i - 1] * 1.05).toInt())
        if (i - 3 >= 0) dp[i] = maxOf(dp[i], (dp[i - 3] * 1.2).toInt())
        if (i - 5 >= 0) dp[i] = maxOf(dp[i], (dp[i - 5] * 1.35).toInt())
    }

    println(dp[Y])
}