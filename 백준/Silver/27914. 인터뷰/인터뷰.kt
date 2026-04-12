fun main() {
    val sb = StringBuilder()
    val (n, k, q) = readln().split(" ").map { it.toInt() }
    val aL = readln().split(" ").map { it.toInt() }
    val xL = readln().split(" ").map { it.toInt() }
    val dp = IntArray(n + 1)
    val preSum = LongArray(n + 1)

    for (i in 0 until n) {
        if (aL[i] == k) {
            dp[i + 1] = 0
            preSum[i + 1] = preSum[i]
        } else {
            dp[i + 1] = dp[i] + 1
            preSum[i + 1] = preSum[i] + dp[i + 1]
        }
    }

    for (i in 0 until q) {
        sb.appendLine(preSum[xL[i]])
    }

    print(sb)
}