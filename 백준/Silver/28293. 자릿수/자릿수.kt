import kotlin.math.log

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    
    println((log(a.toDouble(), 10.0) * b).toInt() + 1)
}