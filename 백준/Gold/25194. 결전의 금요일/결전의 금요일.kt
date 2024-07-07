fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() % 7 }
    val dp = Array(N + 1) { BooleanArray(7) }
    dp[0][0] = true

    for (i in 0 until N) {
        for (j in 0 until 7) {
            if (dp[i][j]) {
                dp[i + 1][j] = true
                dp[i + 1][(j + list[i]) % 7] = true

                if (dp[i + 1][4]) {
                    println("YES")
                    return
                }
            }
        }
    }

    println("NO")
}