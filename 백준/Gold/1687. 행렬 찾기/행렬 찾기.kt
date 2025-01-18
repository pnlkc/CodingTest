fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { CharArray(M) }
    val preSum = Array(N + 1) { IntArray(M + 1) { 0 } }
    var result = 0

    for (i in 0 until N) {
        val str = readln()

        for (j in 0 until M) {
            map[i][j] = str[j]

            if (map[i][j] == '0') {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + 1
            }
        }
    }

    for (i in 1..N) {
        for (j in 1..M) {
            if (map[i - 1][j - 1] == '1') continue

            var minL = Int.MAX_VALUE

            for (k in j downTo 1) {
                if (preSum[i][k] == 0) break

                minL = minOf(minL, preSum[i][k])
                result = maxOf(result, (j - k + 1) * minL)
            }
        }
    }

    println(result)
}