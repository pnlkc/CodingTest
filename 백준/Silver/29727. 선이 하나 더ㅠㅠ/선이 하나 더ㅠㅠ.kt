fun main() {
    val n = readln().toInt()
    val (xa, ya) = readln().split(" ").map { it.toInt() }
    val (xb, yb) = readln().split(" ").map { it.toInt() }

    var cnt = (n + 1).toLong() * n / 2
    var add = 0L
    var a = 0
    var b = 0

    cnt = cnt * cnt

    if (xa == xb) {
        a = minOf(maxOf(ya, -1), n)
        b = minOf(maxOf(yb, -1), n)
    } else if (ya == yb) {
        a = minOf(maxOf(xa, -1), n)
        b = minOf(maxOf(xb, -1), n)
    }

    val diff = maxOf(a, b) - minOf(a, b)

    if (diff > 1) {
        val temp = diff.toLong() * (diff - 1) / 2

        add = temp * (n + 1)
    }

    println(cnt + add)
}