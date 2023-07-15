import kotlin.math.sqrt

fun main() {
    val s = readln()
    val n = s.length
    var r = 0
    var c = 0

    for (i in sqrt(n.toDouble()).toInt() downTo 1) {
        if (n % i == 0) {
            r = i
            c = n / r
            break
        }
    }

    val arr = Array(r) { CharArray(c) }

    for (i in s.indices) {
        arr[i % r][i / r] = s[i]
    }

    println(arr.joinToString("") { it.joinToString("") })
}