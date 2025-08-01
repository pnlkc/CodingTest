fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    val dp = Array(3) { IntArray(N + 1) }

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    for (i in 1..N) {
        dp[0][i] = maxOf(dp[0][i - 1], dp[1][i - 1], dp[2][i - 1])
        dp[1][i] = dp[0][i - 1] + arr[i - 1]
        dp[2][i] = dp[1][i - 1] + arr[i - 1] / 2
    }

    println(maxOf(dp[0][N], dp[1][N], dp[2][N]))
}