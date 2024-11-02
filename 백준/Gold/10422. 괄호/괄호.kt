fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val dp = LongArray(5001)
    val NUM = 1_000_000_007

    dp[0] = 1L
    dp[2] = 1L

    for (i in 4..5000 step 2){
        for (j in 0..i - 2 step 2) {
            dp[i] += (dp[j] * dp[i - 2 - j]) % NUM
            dp[i] = dp[i] % NUM
        }
    }

    for (tc in 1..T) {
        sb.appendLine(dp[readln().toInt()])
    }

    print(sb)
}