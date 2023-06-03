import kotlin.math.abs

fun main() {
    val (n, m) = readln().split(' ').map(String::toLong)
    println(abs(n - m))
}