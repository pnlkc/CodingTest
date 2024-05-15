fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val preSum = IntArray(N + 1)
    val M = readln().toInt()

    for (i in 0 until N) {
        preSum[i + 1] = preSum[i] + list[i]
    }

    for (tc in 1..M) {
        val (i, j) = readln().split(" ").map { it.toInt() }

        sb.appendLine(preSum[j] - preSum[i - 1])
    }

    print(sb)
}