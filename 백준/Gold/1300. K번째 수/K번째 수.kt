fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    var s = 1
    var e = minOf(1_000_000_000, n.toLong() * n).toInt()

    while (s < e) {
        val mid = (s + e) / 2
        var count = 0
        for (i in 1..n) {
            count += minOf(mid / i, n)
            if (count >= k) break
        }

        if (count >= k) e = mid else s = mid + 1
    }

    println(e)
}