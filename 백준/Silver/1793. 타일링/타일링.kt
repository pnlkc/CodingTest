fun main() {
    val sb = StringBuilder()
    val dp = Array(251) { 1.toBigInteger() }

    dp[1] = 1.toBigInteger()
    dp[2] = 3.toBigInteger()

    for (i in 3..250) {
        dp[i] = dp[i - 1].add(dp[i - 2].multiply(2.toBigInteger()))
    }

    while (true) {
        val n = readlnOrNull()?.toInt() ?: break

        sb.appendLine(dp[n])
    }

    print(sb)
}