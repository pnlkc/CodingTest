fun main() {
    val (K, N) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toLong() }
    var num = 1L

    for (i in 0 until N) {
        num = num / gcd(num, list[i]) * list[i]
    }

    println(num - K)
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)