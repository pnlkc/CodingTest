fun main() {
    val N = readln().toInt()
    val lL = readln().split(" ").map { it.toInt() }
    val rL = readln().split(" ").map { it.toInt() }
    val dp = Array(N + 1) { IntArray(N + 1) }
    var max = 0

    calc(0, 0, lL, rL, dp, 0)

    for (i in 0 until N) {
        max = maxOf(max, dp[i][N])
        max = maxOf(max, dp[N][i])
    }

    println(max)
}

fun calc(l: Int, r: Int, lL: List<Int>, rL: List<Int>, dp: Array<IntArray>, result: Int) {
    if (l >= lL.size || r >= rL.size) return
    if (dp[l][r] > result) return

    dp[l + 1][r] = maxOf(dp[l + 1][r], result)
    calc(l + 1, r, lL, rL, dp, result)
    dp[l + 1][r + 1] = maxOf(dp[l + 1][r + 1], result)
    calc(l + 1, r + 1, lL, rL, dp, result)

    if (lL[l] > rL[r]) {
        dp[l][r + 1] = maxOf(dp[l][r + 1], result + rL[r])
        calc(l, r + 1, lL, rL, dp, result + rL[r])
    }
}