import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var s = 0
    var e = N - 1
    var min = Integer.MAX_VALUE
    var result = Integer.MAX_VALUE

    while (s < e) {
        val sum = list[s] + list[e]

        if (sum > 0) e-- else if (sum < 0) s++
        if (min > abs(sum)) {
            min = abs(sum)
            result = sum
        }
        if (min == 0) break
    }

    println(result)
}