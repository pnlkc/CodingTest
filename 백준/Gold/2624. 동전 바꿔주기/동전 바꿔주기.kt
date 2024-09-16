fun main() {
    val T = readln().toInt()
    val k = readln().toInt()
    val arr = Array(k + 1) { 0 to 0 }
    val dp = Array(k + 1) { IntArray(T + 1) }

    dp[0][0] = 1

    for (i in 1..k) {
        val (p, n) = readln().split(" ").map { it.toInt() }
        arr[i] = p to n
    }

    for (i in 1..k) {
        val (p, n) = arr[i]

        for (j in 0..T) {
            for (l in 1..n) {
                val price = p * l

                if (j - price >= 0) dp[i][j] += dp[i - 1][j - price]
            }

            dp[i][j] += dp[i - 1][j]
        }
    }
    
    println(dp[k][T])
}