fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val dp = IntArray(N) { 1 }
    var max = 1

    for (i in 1 until N) {
        for (j in 0 until i) {
            if (arr[i] < arr[j]) dp[i] = maxOf(dp[i], dp[j] + 1)
        }

        max = maxOf(max, dp[i])
    }

    println(max)
}