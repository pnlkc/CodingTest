fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val preSum = mutableListOf(0)
    var cnt = 0

    list.forEach { preSum.add(preSum.last() + it) }

    var s = 0
    var e = 0

    while (s < N && e < N) {
        when {
            preSum[e + 1] - preSum[s] > M -> s++
            preSum[e + 1] - preSum[s] < M -> e++
            else -> {
                cnt++
                e++
            }
        }
    }

    println(cnt)
}
