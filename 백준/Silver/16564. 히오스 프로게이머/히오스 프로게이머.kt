fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N)
    var r = 1L

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    var s = 1L
    var e = 2_000_000_000L

    while (s <= e) {
        val m = (s + e) / 2
        var sum = 0L

        for (i in 0 until N) {
            if (m >= arr[i]) {
                sum += m - arr[i]
                if (sum > K) break
            }
        }

        if (sum > K) {
            e = m - 1
        } else {
            r = maxOf(r, m)
            s = m + 1
        }
    }

    println(r)
}