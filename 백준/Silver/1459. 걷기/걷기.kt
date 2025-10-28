fun main() {
    val (x, y, w, s) = readln().split(" ").map { it.toLong() }

    val a = x * w + y * w
    val b = minOf(x, y) * s + (maxOf(x, y) - minOf(x, y)) * w
    val c = if ((x + y) % 2 == 0L) maxOf(x, y) * s else w + (maxOf(x, y) - 1) * s

    println(minOf(a, b, c))
}