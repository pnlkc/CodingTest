import kotlin.math.pow

fun main() {
    val (A, B) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    println(
        readln()
            .split(" ")
            .mapIndexed { idx, s -> s.toInt() * A.toDouble().pow((m - 1 - idx).toDouble()).toInt() }
            .sum()
            .toString(B)
            .map { it.digitToInt(B) }
            .joinToString(" ")
    )
}