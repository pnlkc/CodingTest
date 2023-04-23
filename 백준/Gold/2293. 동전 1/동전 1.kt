fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1)
    val arr = IntArray(n) { readln().toInt() }.also { it.sort() }

    arr.forEach {
        if (it <= k) dp[it]++
        for (i in dp.indices) {
            if (i + it <= k) dp[i + it] += dp[i]
        }
    }

    println(dp[k])
}