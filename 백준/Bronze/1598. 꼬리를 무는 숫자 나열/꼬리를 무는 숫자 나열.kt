import kotlin.math.abs

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() - 1 }

    println(abs(a / 4 - b / 4) + abs(a % 4 - b % 4))
}