fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arrM = readln().split(" ").map { it.toInt() }
    val arrC = readln().split(" ").map { it.toInt() }
    var dp = IntArray(100_001)
    dp[arrC[0]] = arrM[0]

    for (i in 1 until n) {
        val nDP = dp.clone()

        for (j in dp.indices) {
            if (dp[j] == 0) continue
            nDP[j + arrC[i]] = maxOf(nDP[j + arrC[i]], dp[j] + arrM[i])
        }
        
        nDP[arrC[i]] = maxOf(nDP[arrC[i]], arrM[i])

        dp = nDP
    }

    dp.forEachIndexed { idx, i -> if (i >= m) return println(idx) }
}