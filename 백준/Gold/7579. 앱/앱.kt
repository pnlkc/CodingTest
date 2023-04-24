fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arrM = readln().split(" ").map { it.toInt() }
    val arrC = readln().split(" ").map { it.toInt() }
    var dp = IntArray(100_001) { -1 }
    dp[arrC[0]] = arrM[0]

    for (i in 1 until n) {
        val nDP = IntArray(100_001) { -1 }

        for (j in dp.indices) {
            if (dp[j] == -1) continue

            if (nDP[j + arrC[i]] == -1) nDP[j + arrC[i]] = dp[j] + arrM[i]
            else nDP[j + arrC[i]] = maxOf(nDP[j + arrC[i]], dp[j] + arrM[i])

            if (nDP[j] == -1) nDP[j] = dp[j]
            else nDP[j] = maxOf(nDP[j], dp[j])
        }

        if (nDP[arrC[i]] == -1) nDP[arrC[i]] = arrM[i]
        else nDP[arrC[i]] = maxOf(nDP[arrC[i]], arrM[i])

        dp = nDP
    }

    for (i in dp.indices) {
        if (dp[i] >= m) {
            println(i)
            break
        }
    }
}