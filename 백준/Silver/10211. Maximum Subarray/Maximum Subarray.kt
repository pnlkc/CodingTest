fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()

    for (tc in 1..T) {
        val N = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }
        val preSum = IntArray(N + 1)
        var max = Int.MIN_VALUE

        for (i in 0 until N) {
            preSum[i + 1] += preSum[i] +  list[i]
        }

        for (i in 1..N) {
            for (j in 0 until i) {
                max = maxOf(max, preSum[i] - preSum[j])
            }
        }

        sb.appendLine(max)
    }

    print(sb)
}