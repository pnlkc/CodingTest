fun main() {
    val sb = StringBuilder()
    val A = readln().toInt()
    var dp: IntArray

    for (i in 1..A) {
        dp = IntArray(32)

        for (j in 1..i) {
            dp[j] = 1
        }

        for (j in i + 1..31) {
            dp[j] = 2

            for (k in 1..i) {
                if (dp[j] == 1) break
                if (j - k >= 1 && dp[j - k] == 2) dp[j] = 1
            }
        }

        if (dp[30] == 2) sb.appendLine(i)
    }

    print(sb)
}