fun main() {
    val n = readln()
    val dp = IntArray(n.length + 1)
    dp[0] = 1

    for (i in n.indices) {
        if (n[i] != '0') dp[i + 1] += dp[i]

        if (i > 0 && n[i - 1] != '0' && "${n[i - 1]}${n[i]}".toInt() in 1..34) {
            dp[i + 1] += dp[i - 1]
        }
    }

    println(dp.last())
}