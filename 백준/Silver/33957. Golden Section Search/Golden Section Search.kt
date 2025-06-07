fun main() {
    val N = readln().toInt()
    val lSum = IntArray(N + 1)
    val rSum = IntArray(N + 1)
    var result = 0

    for (i in 0 until N) {
        val (l, r) = readln().split(" ").map { it.toInt() }

        lSum[i + 1] = lSum[i] + l
        rSum[i + 1] = rSum[i] + r
    }

    for (i in 0 until N - 1) {
        if (lSum[i + 1] > rSum[N] - rSum[i + 1] || rSum[i + 1] < lSum[N] - lSum[i + 1]) continue

        result++
    }

    println(result)
}