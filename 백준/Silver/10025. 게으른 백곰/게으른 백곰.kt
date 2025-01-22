fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(1_000_001)
    var sum = 0
    var s = 0
    var e = minOf(1_000_000, 2 * K)
    var max = 0

    for (i in 0 until N) {
        val (g, x) = readln().split(" ").map { it.toInt() }

        arr[x] = g
    }

    for (i in 0..e) {
        sum += arr[i]
    }

    max = maxOf(max, sum)
    s++
    e++

    while (e <= 1_000_000) {
        sum -= arr[s - 1]
        sum += arr[e]
        max = maxOf(max, sum)
        s++
        e++
    }

    println(max)
}