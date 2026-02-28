fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1)

    dp[1] = 2

    for (i in 2..n) {
        dp[i] = dp[i - 1] * 3
    }

    println(dp[n])
}