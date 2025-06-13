fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val SIZE = 191_230
    val dp = IntArray(SIZE)
    val NUM = 1_000_000_007

    dp[1] = 1
    dp[2] = 2

    for (i in 3 until SIZE) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % NUM
    }

    repeat(T) {
        val N = readln().toInt()

        sb.appendLine(dp[N])
    }

    print(sb)
}