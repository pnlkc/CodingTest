fun main() {
    val (ax, ay) = readln().split(" ").map { it.toInt() }
    val (bx, by) = readln().split(" ").map { it.toInt() }
    val (cx, cy) = readln().split(" ").map { it.toInt() }
    val x = if (ax == bx) cx else if (ax == cx) bx else ax
    val y = if (ay == by) cy else if (ay == cy) by else ay
    println("$x $y")
}