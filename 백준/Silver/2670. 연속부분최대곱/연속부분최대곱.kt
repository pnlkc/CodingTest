fun main() {
    val N = readln().toInt()
    val arr = DoubleArray(N)
    val dp = DoubleArray(N)
    var max = 0.0

    for (i in 0 until N) {
        arr[i] = readln().toDouble()
    }

    dp[0] = arr[0]

    for (i in 1 until N) {
        dp[i] = maxOf(dp[i - 1] * arr[i], arr[i])
        max = maxOf(max, dp[i])
    }

    println(String.format("%.3f", max))
}