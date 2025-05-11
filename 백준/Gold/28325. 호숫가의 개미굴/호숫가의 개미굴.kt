fun main() {
    val N = readln().toInt()
    val cArr = readln().split(" ").map { it.toLong() }
    val dp = Array(2) { Array(2) { LongArray(N) } }

    dp[0][0][0] = cArr[0]
    dp[1][1][0] = 1

    for (i in 1 until N) {
        when (i) {
            1 -> {
                dp[0][0][i] = dp[0][0][0] + cArr[i]
                dp[0][1][i] = dp[0][0][0] + 1
                dp[1][0][i] = dp[1][1][0] + cArr[i]
            }
            else -> {
                dp[0][0][i] = maxOf(dp[0][0][i - 1], dp[0][1][i - 1]) + cArr[i]
                dp[1][0][i] = maxOf(dp[1][0][i - 1], dp[1][1][i - 1]) + cArr[i]
                dp[0][1][i] = dp[0][0][i - 1] + 1
            }
        }
    }
    
    println(listOf(dp[0][0][N - 1], dp[0][1][N - 1], dp[1][0][N - 1], dp[1][1][N - 1],).max())
}