import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    var result = 0

    for (i in 1..sqrt(n.toDouble()).toInt()) {
        if (i * i == n) result++ else if (n % i == 0) result += 2
    }

    println(result)
}