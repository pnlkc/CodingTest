fun main() {
    val sb = StringBuilder()
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { listOf<Int>() }
    val preSum = Array(N + 1) { IntArray(M + 1) }

    for (i in 0 until N) {
        map[i] = readln().split(" ").map { it.toInt() }
    }

    for (i in 1..N) {
        for (j in 1.. M) {
            preSum[i][j] = preSum[i][j - 1] + map[i - 1][j - 1]
        }
    }

    for (i in 1..M) {
        for (j in 1..N) {
            preSum[j][i] += preSum[j - 1][i]
        }
    }

    val K = readln().toInt()

    for (k in 0 until K) {
        val (i, j, x, y) = readln().split(" ").map { it.toInt() }

        sb.appendLine(
            preSum[x][y] - preSum[x][j - 1] - preSum[i - 1][y] + preSum[i - 1][j - 1]
        )
    }

    print(sb)
}