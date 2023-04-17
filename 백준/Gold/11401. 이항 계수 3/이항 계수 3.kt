fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var top = 1L
    var bottom = 1L

    for (i in 0 until k) {
        top = top * (n - i) % 1_000_000_007
        bottom = bottom * (i + 1) % 1_000_000_007
    }

    val r = calc(bottom.toInt(), 1_000_000_007).first

    println(top * (if (r < 0) 1_000_000_007 + r else r) % 1_000_000_007)
}

fun calc(a: Int, b: Int): Pair<Int, Int> {
    if (a == 0) return Pair(0, 1)

    val (x1, y1) = calc(b % a, a)
    val x = (y1 - (b / a).toLong() * x1) % 1_000_000_007

    return Pair(x.toInt(), x1)
}