fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val arr = Array(N + 1) { IntArray(N + 1) }
        val rSum = LongArray(N)
        val cSum = LongArray(N)

        for (i in 1..N) {
            val input = readln().split(" ").map { it.toInt() }

            for (j in 1..N) {
                arr[i][j] = input[j - 1]
            }
        }

        for (i in 1..N) {
            for (j in 1..N) {
                rSum[i - 1] = rSum[i - 1] + arr[i][j]
                cSum[i - 1] = cSum[i - 1] + arr[j][i]
            }
        }

        for (i in 0 until M) {
            val (r1, c1, r2, c2, v) = readln().split(" ").map { it.toInt() }

            for (i in r1 - 1 until r2) {
                rSum[i] = rSum[i] + (c2 - c1 + 1) * v
            }

            for (i in c1 - 1 until c2) {
                cSum[i] = cSum[i] + (r2 - r1 + 1) * v
            }
        }

        sb.appendLine(rSum.joinToString(" "))
        sb.appendLine(cSum.joinToString(" "))
    }

    print(sb)
}