fun main() {
    val N = readln().toInt()
    val dp = IntArray(maxOf(5, N + 1))

    dp[1] = 1
    dp[2] = 2
    dp[3] = 1
    dp[4] = 1

    for (i in 5..N) {
        dp[i] = if (dp[i - 1] == 2 || dp[i - 3] == 2 || dp[i - 4] == 2) 1 else 2
    }

    println(if (dp[N - 1] == 1) "SK" else "CY")
}