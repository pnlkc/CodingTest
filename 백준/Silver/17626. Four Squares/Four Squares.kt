fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1) { 5 }
    dp[0] = 0

    for (i in 1..n) {
        for (j in 1..223) {
            if (j * j > i) break
            dp[i] = minOf(dp[i], dp[i - j * j] + 1)
        }
    }

    println(dp[n])
}