import kotlin.math.pow

var count = -1
var answer = -1

fun main() {
    val (n, r, c) = readln().split(" ").map(String::toInt)
    calc(n, 0, 0, r, c)
    println(answer)
}

fun calc(n: Int, y: Int, x: Int, r: Int, c: Int) {
    if (answer != -1) return

    if (n == 0) {
        count++
        if (y == r && x == c) answer = count
        return
    }

    val range = 2.toDouble().pow(n - 1).toInt()
    val xR = intArrayOf(x, x + range, x, x + range)
    val yR = intArrayOf(y, y, y + range, y + range)

    for (i in 0..3) {
        if (r >= yR[i] + range || c >= xR[i] + range) count += range.toDouble().pow(2).toInt()
        else calc(n - 1, yR[i], xR[i], r, c)
    }
}