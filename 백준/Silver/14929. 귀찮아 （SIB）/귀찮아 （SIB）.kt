fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val preSum = IntArray(N + 1)
    var result = 0L

    for (i in 1..N) {
        preSum[i] = preSum[i - 1] + list[i - 1]
    }

    for (i in 0 until  N - 1) {
        result += (preSum[N] - preSum[i + 1]).toLong() * list[i]
    }

    println(result)
}