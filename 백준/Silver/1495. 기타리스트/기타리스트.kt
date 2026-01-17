fun main() {
    val (n, s, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { BooleanArray(m + 1) }
    var result = -1

    dp[0][s] = true

    for (i in 1..n) {
        for (j in 0..m) {
            if (!dp[i - 1][j]) continue
            if (j + list[i - 1] <= m) dp[i][j + list[i - 1]] = true
            if (j - list[i - 1] >= 0) dp[i][j - list[i - 1]] = true
        }
    }

    for (i in 0..m) {
        if (dp[n][i]) result = i
    }

    println(result)
}