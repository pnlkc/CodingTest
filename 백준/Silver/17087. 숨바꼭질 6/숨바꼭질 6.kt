import kotlin.math.abs

fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { abs(s - it.toInt()) }
    var gcd = list[0]

    for (i in 0 until n) {
        gcd = gcd(gcd, list[i])
    }

    println(gcd)
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)