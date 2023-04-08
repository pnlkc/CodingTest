fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }
    if (a % c == 0L) println(0L) else println(calc(a, c, b))
}

fun calc(a: Long, c: Long, n: Long): Long {
    return when (n) {
        1L -> a % c
        else -> {
            val r = calc(a, c, n / 2)
            val rc = r % c
            if (n % 2 == 0L) (rc * rc) % c
            else ((a % c) * ((rc * rc) % c)) % c
        }
    }
}