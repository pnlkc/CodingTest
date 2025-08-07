fun main() {
    val sb = StringBuilder()
    val (N, Q) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    val preSum = IntArray(N + 1)

    for (i in 0 until N) {
        preSum[i + 1] = preSum[i] + list[i]
    }

    repeat (Q) {
        val (L, R) = readln().split(" ").map { it.toInt() }

        sb.appendLine(preSum[R] - preSum[L - 1])
    }

    print(sb)
}