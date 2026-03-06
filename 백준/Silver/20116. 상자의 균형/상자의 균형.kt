fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val preSum = LongArray(n + 1)

    for (i in 0 until n) {
        preSum[i + 1] = preSum[i] + list[i]
    }

    for (i in 1 until n) {
        val mid = (preSum[n] - preSum[i]).toDouble() / (n - i)

        if (mid <= list[i - 1] - l || mid >= list[i - 1] + l) {
            println("unstable")
            return
        }
    }

    println("stable")
}