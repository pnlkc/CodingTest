fun main() {
    val N = readln().toInt()
    val cost = readln().split(" ").map { it.toInt() }
    val happy = readln().split(" ").map { it.toInt() }
    val dp = Array(N + 1) { IntArray(101) }

    for (i in 0 until N) {
        for (j in 100 downTo 1) {
            dp[i + 1][j] = maxOf(dp[i + 1][j], dp[i][j])
            if (j - cost[i] <= 0) continue
            dp[i + 1][j - cost[i]] = maxOf(dp[i + 1][j - cost[i]], dp[i][j] + happy[i])
        }
    }

    println(dp[N].maxOrNull()!!)
}