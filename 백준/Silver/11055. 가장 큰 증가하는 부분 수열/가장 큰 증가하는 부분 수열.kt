fun main() {
    val N = readln().toInt()
    val dp = Array(N + 1) { IntArray(1001) }
    val list = readln().split(" ").map { it.toInt() }

    for (i in 1..N) {
        val num = list[i - 1]

        for (j in 0..1000) {
            if (j < num) {
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j])
                dp[i][num] = maxOf(dp[i][num], dp[i - 1][j] + num)
            } else {
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j])
            }
        }
    }
    
    println(dp[N].maxOrNull())
}