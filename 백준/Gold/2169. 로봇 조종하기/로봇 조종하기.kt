fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    val MIN_NUM = 1000 * 1000 * -100 - 1
    val dp = Array(N) { IntArray(M) { MIN_NUM } }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    // 첫번째 줄 계산
    dp[0][0] = map[0][0]

    for (j in 1 until M) {
        dp[0][j] = dp[0][j - 1] + map[0][j]
    }

    // 두번째 줄부터 N번째 줄 계산
    for (i in 1 until N) {
        val r = IntArray(M) { MIN_NUM }
        val l = IntArray(M) { MIN_NUM }

        for (j in 0 until M) {
            if (r[j] == MIN_NUM) r[j] = dp[i - 1][j] + map[i][j]
            else r[j] = maxOf(r[j], dp[i - 1][j] + map[i][j])

            if (j > 0) r[j] = maxOf(r[j], r[j - 1] + map[i][j])
        }

        for (j in M - 1 downTo 0) {
            if (l[j] == MIN_NUM) l[j] = dp[i - 1][j] + map[i][j]
            else l[j] = maxOf(l[j], dp[i - 1][j] + map[i][j])

            if (j < M - 1) l[j] = maxOf(l[j], l[j + 1] + map[i][j])
        }

        for (j in 0 until M) {
            dp[i][j] = maxOf(r[j], l[j])
        }
    }

    println(dp[N - 1][M - 1])
}