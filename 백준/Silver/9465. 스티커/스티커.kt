fun main() {
    val sb = StringBuilder()
    val tcNum = readln().toInt()

    repeat(tcNum) {
        val n = readln().toInt()
        val arr = Array(2) { listOf<Int>() }
        val dp = Array(2) { IntArray(n + 2) }

        (0..1).forEach { arr[it] = readln().split(' ').map(String::toInt) }

        for (i in 0 until n) {
            dp[0][i + 2] = maxOf(dp[1][i + 1], dp[0][i], dp[1][i]) + arr[0][i]
            dp[1][i + 2] = maxOf(dp[0][i + 1], dp[0][i], dp[1][i]) + arr[1][i]
        }

        sb.appendLine(maxOf(dp[0][n + 1], dp[1][n + 1]))
    }

    println(sb)
}
