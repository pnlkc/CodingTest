import kotlin.math.ceil

fun main() {
    val (a, i) = readln().split(" ").map { it.toInt() }
    var num = a * i

    while (ceil((num - 1).toDouble() / a) == i.toDouble()) {
        num--
    }

    println(num)
}