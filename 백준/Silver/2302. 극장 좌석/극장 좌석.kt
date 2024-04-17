fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val fixed = mutableListOf(0)
    val dp = mutableListOf(0, 1)
    var cnt = 1

    for (i in 0 .. N) {
        dp.add(dp[i] + dp[i + 1])
    }

    for (i in 1..M) {
        fixed.add(readln().toInt())
    }

    fixed.add(N + 1)

    for (i in 0 until fixed.lastIndex) {
        cnt *= dp[fixed[i + 1] - fixed[i]]
    }

    println(cnt)
}