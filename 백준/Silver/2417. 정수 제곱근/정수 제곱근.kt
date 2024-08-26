import kotlin.math.pow

fun main() {
    val n = readln().toLong()
    var s = 0L
    var e = n
    var answer = 0L

    while (s <= e) {
        val mid = (s + e) / 2

        if (mid.toDouble().pow(2) < n) {
            s = mid + 1
        } else {
            answer = mid
            e = mid - 1
        }
    }

    println(answer)
}