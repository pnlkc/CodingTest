fun main() {
    val (n, m) = readln().split(":").map { it.toInt() }
    val gcd = gcd(n, m)

    println("${n / gcd}:${m / gcd}")
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}