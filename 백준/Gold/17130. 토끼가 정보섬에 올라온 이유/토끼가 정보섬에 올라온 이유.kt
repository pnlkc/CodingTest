fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { CharArray(M) }
    val dp = Array(N) { IntArray(M) { -1 } }
    var result = -1
    var sx = 0
    var sy = 0

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j]

            if (map[i][j] == 'R') {
                sx = j
                sy = i

                dp[sy][sx] = 0
            }
        }
    }

    for (j in sx + 1 until M) {
        for (i in 0 until N) {
            if (map[i][j] == '#') continue

            for (dy in -1..1) {
                if (i + dy < 0 || i + dy >= N) continue
                if (dp[i + dy][j - 1] == -1) continue

                dp[i][j] = maxOf(dp[i][j], dp[i + dy][j - 1])
            }

            when (map[i][j]) {
                'C' -> if (dp[i][j] != -1) dp[i][j] = dp[i][j] + 1
                'O' -> result = maxOf(result, dp[i][j])
            }
        }
    }

    println(result)
}