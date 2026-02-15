import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    val max = sqrt(100_000_000.toDouble()).toInt()

    println(if (max < n) "Time limit exceeded" else "Accepted")
}