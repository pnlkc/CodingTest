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


        while (s < e) {
            val m = (s + e) / 2

            if (sL[m] <= pos.x) {
                s = m + 1
            } else {
                e = m - 1
            }
        }

        val m = (s + e) / 2
        var dist = Int.MAX_VALUE
        if (m < 0) {
            dist = abs(pos.x - sL[m + 1]) + pos.y
        } else if (m > 0) {
            dist = minOf(dist, abs(pos.x - sL[m - 1]) + pos.y)
            dist = minOf(dist, abs(pos.x - sL[m]) + pos.y)
            if (m + 1 < M) dist = abs(pos.x - sL[m + 1]) + pos.y
        } else {
            dist = minOf(dist, abs(pos.x - sL[m]) + pos.y)
            if (1 < M) dist = minOf(dist, abs(pos.x - sL[1]) + pos.y)
        }

        if (dist <= L) result++
    }

    println(result)
}