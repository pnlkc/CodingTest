fun main() {
    val n = readln().toInt()
    val (h, d, k) = readln().split(" ").map { it.toInt() }
    val max = d + k * n + 1
    val dp = Array(n + 1) { Array(max) { IntArray(2) } }
    val rL = Array(n) { readln().toInt() }

    dp[0].forEach { it.fill(0) }
    dp[0][d][0] = h
    dp[0][d][1] = h

    for (c in 1..n) {
        val r = rL[c - 1]

        for (i in 0 until max) {
            val aa = dp[c - 1][i][0] - maxOf(0, (r - i) / 2)
            val ba = if (i - k < 0) 0 else dp[c - 1][i - k][0] - maxOf(0, r - i)
            val ca = dp[c - 1][i][0] - maxOf(0, r - i)
            val ab = dp[c - 1][i][1] - maxOf(0, (r - i)  / 2)
            val bb = if (i - k < 0) 0 else dp[c - 1][i - k][1] - maxOf(0, r - i)

            dp[c][i][0] = maxOf(dp[c][i][0], aa, ba)
            dp[c][i][1] = maxOf(dp[c][i][1], ab, bb)
            if (c != n) {
                dp[c + 1][i][1] =  maxOf(dp[c + 1][i][1], ca)
                if (i + k < max) dp[c + 1][i + k][1] =  maxOf(dp[c + 1][i + k][1], ca)
            }
        }
    }

    val result = dp[n].maxOf { it.max() }

    println(if (result <= 0) -1 else result)
}