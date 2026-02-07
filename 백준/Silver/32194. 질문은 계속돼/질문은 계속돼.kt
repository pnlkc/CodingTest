fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val preSum = IntArray(n + 2)

    preSum[1] = 1

    for (i in 2..n + 1) {
        val (c, x, y) = readln().split(" ").map { it.toInt() }

        preSum[i] = if (c == 1) {
            preSum[i - 1] + if (preSum[y] - preSum[x - 1] == y - x + 1) 1 else 0
        } else {
            preSum[i - 1] + if (preSum[y] - preSum[x - 1] == 0) 1 else 0
        }

        sb.appendLine(if (preSum[i] - preSum[i - 1] == 1) "Yes" else "No")
    }

    print(sb)
}