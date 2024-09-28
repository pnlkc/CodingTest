import kotlin.math.abs

data class Pos(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { Pos(-1, -1) }
    val xS = mutableSetOf<Int>()
    val yS = mutableSetOf<Int>()
    val result = LongArray(N)

    for (i in 0 until N) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        arr[i] = Pos(x, y)
        xS.add(x)
        yS.add(y)
    }

    val xL = xS.toList()
    val yL = yS.toList()
    val pL = mutableListOf<Pos>()

    for (i in yL.indices) {
        for (j in xL.indices) {
            pL.add(Pos(xL[j], yL[i]))
        }
    }

    val dist = Array(pL.size) { IntArray(N) }

    for (i in pL.indices) {
        for (j in 0 until N) {
            dist[i][j] = calcDist(pL[i], arr[j])
        }

        dist[i].sort()
    }

    for (i in 0 until N) {
        var min = Long.MAX_VALUE

        for (j in pL.indices) {
            min = minOf(min, dist[j].slice(0..i).sumOf { it.toLong() })
        }

        result[i] = min
    }

    println(result.joinToString(" "))
}

fun calcDist(p1: Pos, p2: Pos) : Int {
    return abs(p1.x - p2.x) + abs(p1.y - p2.y)
}