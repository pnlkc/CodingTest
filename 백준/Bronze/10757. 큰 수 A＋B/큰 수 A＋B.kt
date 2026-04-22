import java.math.BigInteger

fun main() {
    val (a, b) = readln().split(" ").map { it.toBigInteger() }
    println(a + b)
}