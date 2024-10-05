import kotlin.math.abs

data class Pos(val x: Int, val y: Int)

fun main() {
    val (M, N, L) = readln().split(" ").map { it.toInt() }
    val sL = readln().split(" ").map { it.toInt() }.sorted()
    val pArr = Array(N) { Pos(-1, -1) }
    var result = 0

    for (i in 0 until N) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        pArr[i] = Pos(x, y)
    }

    for (pos in pArr) {
        var s = 0
        var e = M - 1

        while (s <= e) {
            val m = (s + e) / 2

            if (abs(sL[m] - pos.x) + pos.y <= L) {
                result++
                break
            }

            if (pos.x < sL[m]) {
                e = m - 1
            } else if (pos.x > sL[m]) {
                s = m + 1
            } else {
                break
            }
        }
    }

    println(result)
}