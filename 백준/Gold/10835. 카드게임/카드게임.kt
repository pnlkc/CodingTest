fun main() {
    val N = readln().toInt()
    val lL = readln().split(" ").map { it.toInt() }
    val rL = readln().split(" ").map { it.toInt() }
    val dp = Array(N + 1) { IntArray(N + 1) { -1 } }

    calc(0, 0, lL, rL, dp)

    println(dp[0][0])
}

fun calc(l: Int, r: Int, lL: List<Int>, rL: List<Int>, dp: Array<IntArray>): Int {
    if (l >= lL.size || r >= rL.size) return 0

    if (dp[l][r] != -1) return dp[l][r]

    dp[l][r] = maxOf(
        0,
        calc(l + 1, r, lL, rL, dp),
        calc(l + 1, r + 1, lL, rL, dp),
        if (lL[l] > rL[r]) rL[r] + calc(l, r + 1, lL, rL, dp) else 0
    )

    return dp[l][r]
}