fun main() {
    val N = readln().toInt()
    val list = listOf(0) + readln().split(" ").map { it.toInt() }
    val dp = list.toIntArray()

    for (i in 1..N) {
        for (j in 1 until i) {
            dp[i] = maxOf(dp[i], dp[i - j] + dp[j])
        }
    }

    println(dp[N])
}