import kotlin.math.abs

data class Pos(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { Pos(0, 0) }
    var sum = 0

    for (i in 0 until N) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        arr[i] = Pos(x, y)

        if (i != 0) sum += calcDist(arr[i - 1], arr[i])
    }

    var max = 0

    for (i in 0 until N - 2) {
        val d1 = calcDist(arr[i], arr[i + 1])
        val d2 = calcDist(arr[i + 1], arr[i + 2])
        val d3 = calcDist(arr[i], arr[i + 2])

        max = maxOf(max, d1 + d2 - d3)
    }

    println(sum - max)
}

fun calcDist(p1: Pos, p2: Pos): Int = abs(p1.x - p2.x) + abs(p1.y - p2.y)