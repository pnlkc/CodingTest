import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    val (x, y, c) = readln().split(" ").map { it.toDouble() }
    val d = sqrt(x * x + y * y)

    val result = when {
        d == 0.0 -> 0
        d == c -> 1
        d < c -> 2
        else -> ceil(d / c).toLong()
    }

    println(result)
}