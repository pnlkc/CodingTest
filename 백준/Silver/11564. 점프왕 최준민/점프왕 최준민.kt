import kotlin.math.abs

fun main() {
    val (k, a, b) = readln().split(" ").map { it.toLong() }
    var result = 0L

    when {
        a == 0L || b == 0L || (a < 0 && b > 0) -> {
            result += 1
            result += abs(a) / k
            result += b / k
        }
        else -> {
            val min = minOf(abs(a), abs(b))
            val max = maxOf(abs(a), abs(b))

            result += max / k
            result -=  min / k
            if (min % k == 0L) result += 1
        }
    }

    println(result)
}