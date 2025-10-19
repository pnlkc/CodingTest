import kotlin.math.sqrt

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n + 1) { IntArray(n + 1) }
    val preSum = Array(n + 1) { IntArray(n + 1) }
    var min = Int.MAX_VALUE

    repeat(m) {
        val (r, c) = readln().split(" ").map { it.toInt() }

        map[r][c] = 1
    }

    for (i in 1..n) {
        for (j in 1..n) {
            preSum[i][j] = preSum[i][j - 1] + map[i][j]
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            preSum[i][j] = preSum[i - 1][j] + preSum[i][j]
        }
    }

    val list = mutableListOf<Int>()

    for (i in 1..(sqrt(m.toDouble()).toInt() + 1)) {
        if (m % i == 0) list.add(i)
    }

    for (k in list.indices) {
        val a = list[k]
        val b = m / list[k]

        for (i in 1..n - a + 1) {
            for (j in 1..n - b + 1) {
                val num = preSum[i + a - 1][j + b - 1] - preSum[i - 1][j + b - 1] - preSum[i + a - 1][j - 1] + preSum[i - 1][j - 1]

                min = minOf(min, m - num)
            }
        }
    }

    println(min)
}