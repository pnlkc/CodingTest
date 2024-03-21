fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val dp = IntArray(n) { 1 }
    var max = 1

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (list[i] > list[j]) dp[i] = maxOf(dp[i], dp[j] + 1)
        }

        max = maxOf(max, dp[i])
    }

    println(max)
}