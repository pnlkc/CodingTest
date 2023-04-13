fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().split(" ").let { it[0].toInt() to it[1].toInt() } }
    val sum = IntArray(n + 1)
    val dp = Array(n) { IntArray(n) }

    sum[0] = arr.first().first
    for (i in arr.indices) { sum[i + 1] = arr[i].second }

    println(calc(sum, dp, 0, n - 1))
}

fun calc(sum: IntArray, dp: Array<IntArray>, s: Int, e: Int): Int {
    if (s == e) return 0

    var result = Int.MAX_VALUE

    for (i in s until e) {
        val f = if (dp[s][i] != 0) dp[s][i] else calc(sum, dp, s, i)
        val b = if (dp[i + 1][e] != 0) dp[i + 1][e] else calc(sum, dp, i + 1, e)
        val c = sum[s] * sum[i + 1] * sum[e + 1]

        result = minOf(result, f + b + c)
    }

    dp[s][e] = result

    return result
}