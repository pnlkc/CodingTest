import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var minDiff = Int.MAX_VALUE
    var min = Int.MAX_VALUE

    for (i in 1..10_000) {
        var diff = 0

        for (j in 0 until N) {
            diff += abs(i - list[j])
        }

        if (minDiff > diff) {
            minDiff = diff
            min = i
        }
    }

    println(min)
}