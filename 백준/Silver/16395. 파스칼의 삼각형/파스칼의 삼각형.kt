fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        dp[i][1] = 1
        dp[i][i] = 1
    }

    println(topDown(k, n, dp))
}

fun topDown(x: Int, y: Int, dp: Array<IntArray>): Int {
    if (x < 1 || y < 1) return 0
    if (dp[y][x] != 0) return dp[y][x]

    val l = if (dp[y - 1][x - 1] != 0) dp[y - 1][x - 1] else topDown(x - 1, y - 1, dp)
    val r = if (dp[y - 1][x] != 0) dp[y - 1][x] else topDown(x, y - 1, dp)

    dp[y][x] = l + r
    return dp[y][x]
}