import kotlin.math.abs

data class Pos(val x: Int = 0, val y: Int = 0)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val pL = Array(N) { Pos() }
    val qL = Array(M) { Pos() }
    var max = 0L

    for (i in 0 until N) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        pL[i] = Pos(x, y)
    }

    for (i in 0 until M) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        qL[i] = Pos(x, y)
    }

    for (i in 0 until M) {
        for ((px, py) in pL) {
            val dx = abs(qL[i].x - px).toLong()
            val dy = abs(qL[i].y - py).toLong()

            max = maxOf(max, dx * dx + dy * dy)
        }
    }

    println(max)
}