import kotlin.math.sqrt

fun main() {
    val (a, b, L) = readln().split(" ").map { it.toLong() }
    val num = a * b / gcd(a, b)
    val list = mutableListOf<Long>()

    for (i in 1L..sqrt(L.toDouble()).toLong()) {
        if (L % i == 0L) {
            list.add(i)
            if (L / i != i) list.add(L / i)
        }
    }

    list.sort()

    for (m in list) {
        val gcd = gcd(num, m)

        if (L == m * num / gcd) {
            println(m)
            return
        }
    }

    println(-1)
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)