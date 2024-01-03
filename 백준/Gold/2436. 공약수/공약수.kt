import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val sqrt = floor(sqrt(b.toFloat() * a)).toInt()
    var min = Long.MAX_VALUE
    var result = 0L to 0L

    for (i in 1..(sqrt / a) + 1) {
        val num = a.toLong() * i

        if (b.toLong() % num == 0L) {
            val gcd = gcd(num, b.toLong() * a / num)

            if (gcd == a.toLong()) {
                val r = num + (b.toLong() * a / num)

                if (min > r) {
                    min = r
                    result = num to (b.toLong() * a / num)
                }
            }
        }
    }

    println("${result.first} ${result.second}")
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)