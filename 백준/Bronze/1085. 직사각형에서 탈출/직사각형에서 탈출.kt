fun main() {
    val (x, y, w, h) = readln().split(" ").map { it.toInt() }
    println(minOf(x - 0, y - 0, w - x, h - y))
}