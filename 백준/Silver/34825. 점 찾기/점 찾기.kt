import kotlin.math.abs

fun main() {
    val (xa, ya) = readln().split(" ").map { it.toLong() }
    val (xb, yb) = readln().split(" ").map { it.toLong() }
    val dx = abs(xa - xb)
    val dy = abs(ya - yb)
    val d = dx + dy

    println(
        if (d % 2 != 0L) {
            -1
        } else {
            if (d / 2 <= dx) {
                "${xa + (d / 2) * if (xa > xb) -1 else 1} $ya"
            } else {
                "$xb ${ya + ((d / 2) - dx) * if (ya > yb) -1 else 1}"
            }
        }
    )
}