import java.util.*
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)) {
    while (hasNextInt()) {
        val num = 3.0.pow(nextDouble()).toInt()
        val array = CharArray(num) { '-' }
        calc(array, 0, num - 1)
        println(array.joinToString(""))
    }
}

fun calc(array: CharArray, s: Int, e: Int) {
    if (s == e) return
    val r = (e - s + 1) / 3
    calc(array, s, s + r - 1)
    for (i in s + r until  s+ r + r) {
        array[i] = ' '
    }
    calc(array, s + r + r, e)
}