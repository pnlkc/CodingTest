fun main() {
    val (a, b, k, m) = readln().split(" ").map { it.toLong() }
    var s = 1
    var e = 10
    var cnt = 0

    repeat(k.toInt() - 1) {
        s *= 10
        e *= 10
    }

    e--

    p@for (num in s..e) {
        val numStr = num.toString()
        var str = 0L
        var idx = 0
        var cLen = 0

        while (str < a) {
            str *= 10
            str += numStr[idx].digitToInt()
            if (++idx >= k) idx = 0
            cLen++
        }

        if (cLen >= k && str % m == 0L && str in a..b) cnt++
        if (str > b) continue@p

        while (str < b) {
            str *= 10
            str += numStr[idx].digitToInt()
            if (++idx >= k) idx = 0
            if (++cLen >= k && str % m == 0L && str in a..b) cnt++
            if (str > b) continue@p
        }
    }

    println(cnt)
}